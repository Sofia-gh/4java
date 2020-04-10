package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IMemberSignMapper;
import com.zhiyou100.gym.pojo.MemberSign;
import com.zhiyou100.gym.service.IMemberSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service("memberSignService")
public class MemberSignServiceImpl implements IMemberSignService {
    @Autowired
    private IMemberSignMapper memberSignMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<MemberSign> findByPage(Integer page) {
        IPage<MemberSign> memberSignPage = new Page<>(page,KEY);
        return memberSignMapper.selectPage(memberSignPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = memberSignMapper.selectCount(null);
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(MemberSign memberSign) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        memberSign.setNumber(number);
        return memberSignMapper.insert(memberSign);
    }

    @Override
    public int update(MemberSign memberSign) {
        memberSign.setStatus(2);
        memberSign.setOutTime(Timestamp.valueOf(LocalDateTime.now()));
        return memberSignMapper.updateById(memberSign);
    }

}
