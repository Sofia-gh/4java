package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.gym.mapper.IClassOrderMapper;
import com.zhiyou100.gym.pojo.ClassOrder;
import com.zhiyou100.gym.service.IClassOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service("classOrderService")
public class ClassOrderServiceImpl implements IClassOrderService {
    @Autowired
    private IClassOrderMapper classOrderMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<ClassOrder> findByPage(Integer page,ClassOrder classOrder) {
        IPage<ClassOrder> classOrderPage = new Page<>(page,KEY);
        return classOrderMapper.selectPage(classOrderPage,new QueryWrapper<>(classOrder)).getRecords();
    }

    @Override
    public int findMaxPage(ClassOrder classOrder) {
        int count = classOrderMapper.selectCount(new QueryWrapper<>(classOrder));
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(ClassOrder classOrder) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        classOrder.setNumber(number);
        return classOrderMapper.insert(classOrder);
    }

    @Override
    public int delete(ClassOrder classOrder) {
        classOrder.setStatus(0);
        return classOrderMapper.updateById(classOrder);
    }

    @Override
    public List<ClassOrder> findByMemberNumber(Integer page,Integer memberNumber) {
        PageHelper.startPage(page,10);
        PageInfo<ClassOrder> classOrderPageInfo = new PageInfo<>(classOrderMapper.selectPageByMemberNumber(memberNumber));
        return classOrderPageInfo.getList();
    }

}
