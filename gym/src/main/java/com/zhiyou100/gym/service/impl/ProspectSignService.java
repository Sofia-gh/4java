package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IProspectSignMapper;
import com.zhiyou100.gym.pojo.ProspectSign;
import com.zhiyou100.gym.service.IProspectSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service
public class ProspectSignService implements IProspectSignService {
    @Autowired
    private IProspectSignMapper prospectSignMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<ProspectSign> findByPage(Integer page) {
        IPage<ProspectSign> prospectSignIPage = new Page<>(page,10);
        return prospectSignMapper.selectPage(prospectSignIPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = prospectSignMapper.selectCount(null);
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(ProspectSign prospectSign) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        prospectSign.setNumber(number);
        return prospectSignMapper.insert(prospectSign);
    }

}
