package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.ICabinetInfoMapper;
import com.zhiyou100.gym.mapper.ICabinetMapper;
import com.zhiyou100.gym.pojo.Cabinet;
import com.zhiyou100.gym.pojo.CabinetInfo;
import com.zhiyou100.gym.service.ICabinetInfoService;
import com.zhiyou100.gym.service.ICabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service
public class CabinetInfoService implements ICabinetInfoService {
    @Autowired
    private ICabinetInfoMapper cabinetInfoMapper;
    @Autowired
    private ICabinetMapper cabinetMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<CabinetInfo> findByPage(Integer page) {
        IPage<CabinetInfo> cabinetInfoIPage = new Page<>(page,10);
        return cabinetInfoMapper.selectPage(cabinetInfoIPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = cabinetInfoMapper.selectCount(null);
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(CabinetInfo cabinetInfo) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        cabinetInfo.setNumber(number);
        cabinetInfo.setUpdateTime(Timestamp.valueOf(now));
        cabinetInfoMapper.insert(cabinetInfo);
        Cabinet cabinet = new Cabinet();
        cabinet.setNumber(cabinetInfo.getCabinetNumber());
        Cabinet cabinet1 = cabinetMapper.selectOne(new QueryWrapper<>(cabinet));
        cabinet.setStatus(2);
        cabinetMapper.update(cabinet,new QueryWrapper<>(cabinet1));
        return 1;
    }

}
