package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.IAchievementMapper;
import com.zhiyou100.gym.pojo.Achievement;
import com.zhiyou100.gym.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service("achievementService")
public class AchievementServiceImpl implements IAchievementService {
    @Autowired
    private IAchievementMapper achievementMapper;

    private static final int KEY = 10;
    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Achievement> findByPage(Integer page) {
        IPage<Achievement> achievementPage = new Page<>(page,KEY);
        return achievementMapper.selectPage(achievementPage,null).getRecords();
    }

    @Override
    public int findMaxPage() {
        int count = achievementMapper.selectCount(null);
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }

    @Override
    public int insert(Achievement achievement) {
        LocalDateTime now = LocalDateTime.now();
        long number = Long.valueOf(String.valueOf(now.getYear())+String.valueOf(now.getMonthValue())+String.valueOf(now.getDayOfMonth())+String.valueOf(Instant.now().getEpochSecond()));
        achievement.setNumber(number);
        achievement.setUpdateTime(Timestamp.valueOf(now));
        return achievementMapper.insert(achievement);
    }

    @Override
    public Achievement findById(Integer id) {
        return achievementMapper.selectById(id);
    }

    @Override
    public int update(Achievement achievement) {
        LocalDateTime now = LocalDateTime.now();
        achievement.setUpdateTime(Timestamp.valueOf(now));
        return achievementMapper.updateById(achievement);
    }

    @Override
    public int delete(Achievement achievement) {
        achievement.setStatus(0);
        LocalDateTime now = LocalDateTime.now();
        achievement.setUpdateTime(Timestamp.valueOf(now));
        return achievementMapper.updateById(achievement);
    }

}
