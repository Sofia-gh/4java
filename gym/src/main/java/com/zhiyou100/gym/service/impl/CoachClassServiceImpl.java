package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.gym.mapper.ICoachClassMapper;
import com.zhiyou100.gym.pojo.CoachClass;
import com.zhiyou100.gym.service.ICoachClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sofia
 */
@Service("coachClassService")
public class CoachClassServiceImpl implements ICoachClassService {
    @Autowired
    private ICoachClassMapper coachClassMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<CoachClass> findByPage(Integer page, Integer coachNumber) {
        PageHelper.startPage(page,KEY);
        List<CoachClass> classes = null;
        if (coachNumber!=null){
            classes = coachClassMapper.findByCoachNumber(coachNumber);
        }else {
            classes = coachClassMapper.find();
        }
        return new PageInfo<CoachClass>(classes).getList();
    }

    @Override
    public int findMaxPage(Integer coachNumber) {
        CoachClass coachClass = new CoachClass();
        coachClass.setCoachNumber(coachNumber);
        int count = coachClassMapper.selectCount(new QueryWrapper<>(coachClass));
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(CoachClass coachClass) {
        LocalDateTime startTime = coachClass.getStartTime().toLocalDateTime();
        int number = Integer.valueOf(String.valueOf(coachClass.getCoachNumber()%1000)+String.valueOf(startTime.getYear())+String.valueOf(startTime.getMonthValue())+String.valueOf(startTime.getDayOfMonth()+String.valueOf(startTime.getHour())));
        coachClass.setNumber(number);
        return coachClassMapper.insert(coachClass);
    }

    @Override
    public CoachClass findById(Integer id) {
        return coachClassMapper.selectById(id);
    }

    @Override
    public int update(CoachClass coachClass) {
        return coachClassMapper.updateById(coachClass);
    }

    @Override
    public int delete(CoachClass coachClass) {
        return coachClassMapper.deleteById(coachClass);
    }

    @Override
    public int end(CoachClass coachClass) {
        coachClass.setStatus(2);
        return coachClassMapper.updateById(coachClass);
    }

    @Override
    public int finish(CoachClass coachClass) {
        coachClass.setStatus(3);
        return coachClassMapper.updateById(coachClass);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Integer> findCount(Integer number) {
        List<Integer> counts = new ArrayList<>();
        CoachClass coachClass = new CoachClass();
        coachClass.setCoachNumber(number);
        Integer count1 = coachClassMapper.selectCount(new QueryWrapper<>(coachClass));
        coachClass.setStatus(1);
        Integer count2 = coachClassMapper.selectCount(new QueryWrapper<>(coachClass));
        coachClass.setStatus(2);
        Integer count3 = coachClassMapper.selectCount(new QueryWrapper<>(coachClass));
        coachClass.setStatus(3);
        Integer count4 = coachClassMapper.selectCount(new QueryWrapper<>(coachClass));
        counts.add(count1);
        counts.add(count2);
        counts.add(count3);
        counts.add(count4);
        return counts;
    }

    @Override
    public List<CoachClass> findByStatus() {
        CoachClass coachClass = new CoachClass();
        coachClass.setStatus(2);
        return coachClassMapper.selectList(new QueryWrapper<>(coachClass));
    }

    @Override
    public List<CoachClass> find(String key) {
        return coachClassMapper.selectList(new QueryWrapper<CoachClass>().like("name",key).or().like("label",key));
    }


}
