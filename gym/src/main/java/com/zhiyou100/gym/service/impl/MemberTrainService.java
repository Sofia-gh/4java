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
import java.time.LocalTime;
import java.util.ArrayList;
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
    public List<MemberTrain> findByPage(Integer page,Integer number) {
        IPage<MemberTrain> memberTrainIPage = new Page<>(page,10);
        MemberTrain memberTrain = new MemberTrain();
        memberTrain.setMemberNumber(number);
        return memberTrainMapper.selectPage(memberTrainIPage,new QueryWrapper<>(memberTrain)).getRecords();
    }

    @Override
    public int findMaxPage(Integer number) {
        MemberTrain memberTrain = new MemberTrain();
        memberTrain.setMemberNumber(number);
        int count = memberTrainMapper.selectCount(new QueryWrapper<>(memberTrain));
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

    @Override
    public List<Double> findAll(Integer number) {
        final String KEY1 = "跑步机";
        final String KEY2 = "单车";
        final String KEY3 = "蝴蝶机";
        MemberTrain memberTrain = new MemberTrain();
        memberTrain.setMemberNumber(number);
        List<MemberTrain> trains = memberTrainMapper.selectList(new QueryWrapper<>(memberTrain));
        double a = 0;
        double b = 0;
        double c = 0;
        for (MemberTrain train:trains) {
            if (train.getEquipment().equals(KEY1)){
                a = a+(double)Math.round((double)(train.getEndTime().getTime()-train.getStartTime().getTime())/(1000 * 60 * 6))/10;
            }
            if (train.getEquipment().equals(KEY2)){
                b = b+(double)Math.round((double)(train.getEndTime().getTime()-train.getStartTime().getTime())/(1000 * 60 * 6))/10;
            }
            if (train.getEquipment().equals(KEY3)){
                c = c+(double)Math.round((double)(train.getEndTime().getTime()-train.getStartTime().getTime())/(1000 * 60 * 6))/10;
            }
        }
        List<Double> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }

}
