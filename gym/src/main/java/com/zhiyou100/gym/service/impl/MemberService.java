package com.zhiyou100.gym.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.gym.mapper.IMemberMapper;
import com.zhiyou100.gym.pojo.Member;
import com.zhiyou100.gym.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service
public class MemberService implements IMemberService {
    @Autowired
    private IMemberMapper memberMapper;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Member> findByPage(Integer page, String key) {
        PageHelper.startPage(page,10);
        List<Member> members = null;
        if (StringUtils.isEmpty(key)){
            members = memberMapper.findAll();
        }else {
            members = memberMapper.find(key);
        }
        return new PageInfo<Member>(members).getList();
    }

    @Override
    public int findMaxPage(String key) {
        int count;
        if (StringUtils.isEmpty(key)){
            count = memberMapper.selectCount(null);
        }else {
            count = memberMapper.findCount(key);
        }
        int mPage = count / 10;
        if (count % 10 != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(Member member) {
        LocalDateTime now = LocalDateTime.now();
        member.setUpdateTime(Timestamp.valueOf(now));
        return memberMapper.insert(member);
    }

    @Override
    public Member findById(Integer id) {
        return memberMapper.selectById(id);
    }

    @Override
    public int update(Member member) {
        LocalDateTime now = LocalDateTime.now();
        member.setUpdateTime(Timestamp.valueOf(now));
        return memberMapper.updateById(member);
    }

    @Override
    public int delete(Member member) {
        member.setStatus(0);
        LocalDateTime now = LocalDateTime.now();
        member.setUpdateTime(Timestamp.valueOf(now));
        return memberMapper.updateById(member);
    }

    @Override
    public Member findByNumber(Integer number) {
        return memberMapper.findByNumber(number);
    }
}
