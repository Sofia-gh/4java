package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IMemberRechargeMapper;
import com.zhiyou100.gym.pojo.MemberRecharge;
import com.zhiyou100.gym.service.IMemberRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service
public class MemberRechargeService implements IMemberRechargeService {
    @Autowired
    private IMemberRechargeMapper memberRechargeMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<MemberRecharge> findByPage(Integer page) {
        IPage<MemberRecharge> memberRechargeIPage = new Page<>(page,10);
        return memberRechargeMapper.selectPage(memberRechargeIPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = memberRechargeMapper.selectCount(null);
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(MemberRecharge memberRecharge) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        memberRecharge.setNumber(number);
        return memberRechargeMapper.insert(memberRecharge);
    }


}
