package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Card;

import java.util.List;

/**
 * @author Sofia
 */
public interface ICardService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询会员卡信息
     * @param page
     * @return List<Card>
     */
    public List<Card> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 添加会员卡信息
     * @param card
     * @return int
     */
    public int insert(Card card);

    /**
     * 根据id查询会员卡信息
     * @param id
     * @return
     */
    public Card findById(Integer id);

    /**
     * 修改会员卡信息
     * @param card
     * @return int
     */
    public int update(Card card);

    /**
     * 删除会员卡信息
     * @param card
     * @return int
     */
    public int delete(Card card);

    /**
     * 查询全部有效会员卡信息
     * @return List<Card>
     */
    public List<Card> findAll();

}
