package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.StaffSign;

import java.util.List;

/**
 * @author Sofia
 */
public interface IStaffSignService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询员工签到信息
     * @param page
     * @return List<StaffSign>
     */
    public List<StaffSign> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 员工签到
     * @param staffSign
     * @return int
     */
    public int insert(StaffSign staffSign);
}
