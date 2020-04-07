package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Staff;

import java.util.List;

/**
 * @author Sofia
 */
public interface IStaffService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询员工信息
     * @param page
     * @return List<Staff>
     */
    public List<Staff> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 添加员工
     * @param staff
     * @return int
     */
    public int insert(Staff staff);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    public Staff findById(Integer id);

    /**
     * 修改员工信息
     * @param staff
     * @return int
     */
    public int update(Staff staff);

    /**
     * 删除员工信息
     * @param staff
     * @return int
     */
    public int delete(Staff staff);
}
