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
@Service("memberRechargeService")
public class MemberRechargeServiceImpl implements IMemberRechargeService {
    @Autowired
    private IMemberRechargeMapper memberRechargeMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<MemberRecharge> findByPage(Integer page) {
        IPage<MemberRecharge> memberRechargePage = new Page<>(page,KEY);
        return memberRechargeMapper.selectPage(memberRechargePage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = memberRechargeMapper.selectCount(null);
        int mPage = count / KEY;
        if (count % KEY != 0) {
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
