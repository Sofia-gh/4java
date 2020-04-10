package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IMaintenanceMapper;
import com.zhiyou100.gym.pojo.Maintenance;
import com.zhiyou100.gym.service.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service("maintenanceService")
public class MaintenanceServiceImpl implements IMaintenanceService {
    @Autowired
    private IMaintenanceMapper maintenanceMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Maintenance> findByPage(Integer page) {
        IPage<Maintenance> maintenancePage = new Page<>(page,KEY);
        return maintenanceMapper.selectPage(maintenancePage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = maintenanceMapper.selectCount(null);
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(Maintenance maintenance) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        maintenance.setNumber(number);
        maintenance.setUpdateTime(Timestamp.valueOf(now));
        return maintenanceMapper.insert(maintenance);
    }

    @Override
    public Maintenance findById(Integer id) {
        return maintenanceMapper.selectById(id);
    }

    @Override
    public int update(Maintenance maintenance) {
        LocalDateTime now = LocalDateTime.now();
        maintenance.setUpdateTime(Timestamp.valueOf(now));
        return maintenanceMapper.updateById(maintenance);
    }

    @Override
    public int delete(Maintenance maintenance) {
        maintenance.setStatus(0);
        LocalDateTime now = LocalDateTime.now();
        maintenance.setUpdateTime(Timestamp.valueOf(now));
        return maintenanceMapper.updateById(maintenance);
    }

}
