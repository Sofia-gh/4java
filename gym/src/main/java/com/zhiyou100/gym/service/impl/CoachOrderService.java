package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.gym.mapper.ICoachClassMapper;
import com.zhiyou100.gym.mapper.ICoachOrderMapper;
import com.zhiyou100.gym.pojo.ClassOrder;
import com.zhiyou100.gym.pojo.CoachClass;
import com.zhiyou100.gym.pojo.CoachOrder;
import com.zhiyou100.gym.service.ICoachClassService;
import com.zhiyou100.gym.service.ICoachOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service
public class CoachOrderService implements ICoachOrderService {
    @Autowired
    private ICoachOrderMapper coachOrderMapper;
    @Autowired
    private ICoachClassMapper coachClassMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<CoachOrder> findByPage(Integer page, CoachOrder coachOrder){
        IPage<CoachOrder> coachOrderIPage = new Page<>(page,10);
        return coachOrderMapper.selectPage(coachOrderIPage,new QueryWrapper<>(coachOrder)).getRecords();
    }

    @Override
    public int findMaxPage(CoachOrder coachOrder) {
        int count = coachOrderMapper.selectCount(new QueryWrapper<>(coachOrder));
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(CoachOrder coachOrder) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        coachOrder.setNumber(number);
        coachOrderMapper.insert(coachOrder);
        CoachClass coachClass = new CoachClass();
        coachClass = coachClassMapper.findByNumber(coachOrder.getCoachClassNumber());
        coachClass.setStatus(2);
        return coachClassMapper.updateById(coachClass);
    }

    @Override
    public int delete(CoachOrder coachOrder) {
        coachOrder.setStatus(0);
        return coachOrderMapper.updateById(coachOrder);
    }

    @Override
    public List<CoachOrder> findByMemberNumber(Integer page, Integer memberNumber) {
        PageHelper.startPage(page,10);
        PageInfo<CoachOrder> coachOrderPageInfo = new PageInfo<>(coachOrderMapper.selectPageByMemberNumber(memberNumber));
        return coachOrderPageInfo.getList();
    }
}
