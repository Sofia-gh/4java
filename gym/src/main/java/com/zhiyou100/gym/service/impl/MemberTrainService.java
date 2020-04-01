package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IMemberTrainMapper;
import com.zhiyou100.gym.pojo.MemberTrain;
import com.zhiyou100.gym.service.IMemberTrainService;
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
public class MemberTrainService implements IMemberTrainService {
    @Autowired
    private IMemberTrainMapper memberTrainMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<MemberTrain> findByPage(Integer page) {
        IPage<MemberTrain> memberTrainIPage = new Page<>(page,10);
        return memberTrainMapper.selectPage(memberTrainIPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = memberTrainMapper.selectCount(null);
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(MemberTrain memberTrain) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        memberTrain.setNumber(number);
        memberTrainMapper.insert(memberTrain);
        return memberTrainMapper.selectOne(new QueryWrapper<>(memberTrain)).getId();
    }

    @Override
    public int update(MemberTrain memberTrain) {
        memberTrain.setStatus(2);
        memberTrain.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
        return memberTrainMapper.updateById(memberTrain);
    }

}
