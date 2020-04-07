package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Maintenance;

import java.util.List;

/**
 * @author Sofia
 */
public interface IMaintenanceService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询维护记录
     * @param page
     * @return List<Maintenance>
     */
    public List<Maintenance> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 添加维护记录
     * @param maintenance
     * @return int
     */
    public int insert(Maintenance maintenance);

    /**
     * 根据id查询维护记录
     * @param id
     * @return
     */
    public Maintenance findById(Integer id);

    /**
     * 修改维护记录
     * @param maintenance
     * @return int
     */
    public int update(Maintenance maintenance);

    /**
     * 删除维护记录
     * @param maintenance
     * @return int
     */
    public int delete(Maintenance maintenance);
}
