package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Member;

import java.util.List;

/**
 * @author Sofia
 */
public interface IMemberService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询会员信息
     * @param page
     * @param key
     * @return List<Member>
     */
    public List<Member> findByPage(Integer page, String key);

    /**
     * 总页数查询
     * @param key
     * @return mPage
     */
    public int findMaxPage(String key);

    /**
     * 添加会员信息
     * @param member
     * @return int
     */
    public int insert(Member member);

    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    public Member findById(Integer id);

    /**
     * 修改会员信息
     * @param member
     * @return int
     */
    public int update(Member member);

    /**
     * 删除会员信息
     * @param member
     * @return int
     */
    public int delete(Member member);

    /**
     * 根据会员编号查询会员信息
     * @param number
     * @return
     */
    public Member findByNumber(Integer number);

}
