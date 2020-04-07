package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IStaffMapper;
import com.zhiyou100.gym.pojo.Staff;
import com.zhiyou100.gym.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service
public class StaffService implements IStaffService {
    @Autowired
    private IStaffMapper staffMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Staff> findByPage(Integer page) {
        IPage<Staff> staffIPage = new Page<>(page,10);
        return staffMapper.selectPage(staffIPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = staffMapper.selectCount(null);
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(Staff staff) {
        LocalDateTime now = LocalDateTime.now();
        staff.setUpdateTime(Timestamp.valueOf(now));
        return staffMapper.insert(staff);
    }

    @Override
    public Staff findById(Integer id) {
        return staffMapper.selectById(id);
    }

    @Override
    public int update(Staff staff) {
        LocalDateTime now = LocalDateTime.now();
        staff.setUpdateTime(Timestamp.valueOf(now));
        return staffMapper.updateById(staff);
    }

    @Override
    public int delete(Staff staff) {
        staff.setStatus(0);
        LocalDateTime now = LocalDateTime.now();
        staff.setUpdateTime(Timestamp.valueOf(now));
        return staffMapper.updateById(staff);
    }

}
