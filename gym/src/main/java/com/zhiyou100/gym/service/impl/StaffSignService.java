package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IStaffSignMapper;
import com.zhiyou100.gym.pojo.StaffSign;
import com.zhiyou100.gym.service.IStaffSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service
public class StaffSignService implements IStaffSignService {
    @Autowired
    private IStaffSignMapper staffSignMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<StaffSign> findByPage(Integer page) {
        IPage<StaffSign> staffSignIPage = new Page<>(page,10);
        return staffSignMapper.selectPage(staffSignIPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = staffSignMapper.selectCount(null);
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(StaffSign staffSign) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        staffSign.setNumber(number);
        return staffSignMapper.insert(staffSign);
    }

}
