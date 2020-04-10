package com.zhiyou100.gym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiyou100.gym.mapper.ICardMapper;
import com.zhiyou100.gym.pojo.Card;
import com.zhiyou100.gym.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sofia
 */
@Service("cardService")
public class CardServiceImpl implements ICardService {
    @Autowired
    private ICardMapper cardMapper;

    private static final int KEY = 10;

    @Override
    public int findCurrentPage(Integer page){
        if (page == null || page < 1) {
            page = 1;
        }
        return page;
    }

    @Override
    public List<Card> findByPage(Integer page) {
        IPage<Card> cardPage = new Page<>(page,KEY);
        Card card = new Card();
        card.setStatus(1);
        return cardMapper.selectPage(cardPage,new QueryWrapper<>(card)).getRecords();
    }

    @Override
    public int findMaxPage() {
        Card card = new Card();
        card.setStatus(1);
        int count = cardMapper.selectCount(new QueryWrapper<>(card));
        int mPage = count / KEY;
        if (count % KEY != 0) {
            mPage ++;
        }
        return mPage;
    }


    @Override
    public int insert(Card card) {
        LocalDateTime now = LocalDateTime.now();
        card.setUpdateTime(Timestamp.valueOf(now));
        return cardMapper.insert(card);
    }

    @Override
    public Card findById(Integer id) {
        return cardMapper.selectById(id);
    }

    @Override
    public int update(Card card) {
        LocalDateTime now = LocalDateTime.now();
        card.setUpdateTime(Timestamp.valueOf(now));
        return cardMapper.updateById(card);
    }

    @Override
    public int delete(Card card) {
        card.setStatus(0);
        LocalDateTime now = LocalDateTime.now();
        card.setUpdateTime(Timestamp.valueOf(now));
        return cardMapper.updateById(card);
    }

    @Override
    public List<Card> findAll() {
        Card card = new Card();
        card.setStatus(1);
        return cardMapper.selectList(new QueryWrapper<>(card));
    }

}
