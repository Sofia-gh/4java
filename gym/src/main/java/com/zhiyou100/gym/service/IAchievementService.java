package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Achievement;

import java.util.List;

/**
 * @author Sofia
 */
public interface IAchievementService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询员工信息
     * @param page
     * @return List<Achievement>
     */
    public List<Achievement> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 添加员工
     * @param achievement
     * @return int
     */
    public int insert(Achievement achievement);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    public Achievement findById(Integer id);

    /**
     * 修改员工信息
     * @param achievement
     * @return int
     */
    public int update(Achievement achievement);

    /**
     * 删除员工信息
     * @param achievement
     * @return int
     */
    public int delete(Achievement achievement);
}
