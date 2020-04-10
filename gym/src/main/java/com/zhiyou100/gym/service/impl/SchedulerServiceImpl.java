package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.ISchedulerMapper;
import com.zhiyou100.gym.mapper.IStaffMapper;
import com.zhiyou100.gym.pojo.Scheduler;
import com.zhiyou100.gym.pojo.Staff;
import com.zhiyou100.gym.service.ISchedulerService;
import com.zhiyou100.gym.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service("schedulerService")
public class SchedulerServiceImpl implements ISchedulerService {
    @Autowired
    private ISchedulerMapper schedulerMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Scheduler> findByPage(Integer page,Integer number) {
        IPage<Scheduler> schedulerPage = new Page<>(page,KEY);
        Scheduler scheduler = new Scheduler();
        scheduler.setCoachNumber(number);
        return schedulerMapper.selectPage(schedulerPage,new QueryWrapper<>(scheduler)).getRecords();
    }

    @Override
    public int findMaxPage(Integer number) {
        Scheduler scheduler = new Scheduler();
        scheduler.setCoachNumber(number);
        int count = schedulerMapper.selectCount(new QueryWrapper<>(scheduler));
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(Scheduler scheduler) {
        LocalDateTime now = LocalDateTime.now();
        scheduler.setUpdateTime(Timestamp.valueOf(now));
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        scheduler.setNumber(number);
        return schedulerMapper.insert(scheduler);
    }

    @Override
    public Scheduler findById(Integer id) {
        return schedulerMapper.selectById(id);
    }

    @Override
    public int update(Scheduler scheduler) {
        LocalDateTime now = LocalDateTime.now();
        scheduler.setUpdateTime(Timestamp.valueOf(now));
        return schedulerMapper.updateById(scheduler);
    }

    @Override
    public int delete(Scheduler scheduler) {
        scheduler.setStatus(0);
        LocalDateTime now = LocalDateTime.now();
        scheduler.setUpdateTime(Timestamp.valueOf(now));
        return schedulerMapper.updateById(scheduler);
    }

}
