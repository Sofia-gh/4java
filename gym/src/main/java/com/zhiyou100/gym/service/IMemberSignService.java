package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.MemberSign;

import java.util.List;

/**
 * @author Sofia
 */
public interface IMemberSignService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询会员进出场信息
     * @param page
     * @return List<MemberSign>
     */
    public List<MemberSign> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 会员进场
     * @param memberSign
     * @return 0/1
     */
    public int insert(MemberSign memberSign);

    /**
     * 会员离场
     * @param memberSign
     * @return 0/1
     */
    public int update(MemberSign memberSign);
}
