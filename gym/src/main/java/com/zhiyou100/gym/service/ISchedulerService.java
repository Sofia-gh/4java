package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Scheduler;

import java.util.List;

/**
 * @author Sofia
 */
public interface ISchedulerService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询员工信息
     * @param page
     * @return List<Scheduler>
     */
    public List<Scheduler> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 添加员工
     * @param scheduler
     * @return int
     */
    public int insert(Scheduler scheduler);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    public Scheduler findById(Integer id);

    /**
     * 修改员工信息
     * @param scheduler
     * @return int
     */
    public int update(Scheduler scheduler);

    /**
     * 删除员工信息
     * @param scheduler
     * @return int
     */
    public int delete(Scheduler scheduler);
}
