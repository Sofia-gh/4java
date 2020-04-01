package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.MemberRecharge;

import java.util.List;

/**
 * @author Sofia
 */
public interface IMemberRechargeService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询会员充值信息
     * @param page
     * @return List<MemberRecharge>
     */
    public List<MemberRecharge> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 会员充值
     * @param memberRecharge
     * @return int
     */
    public int insert(MemberRecharge memberRecharge);

}
