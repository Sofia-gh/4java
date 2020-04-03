package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.CoachClass;

import java.util.List;

/**
 * @author Sofia
 */
public interface ICoachClassService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询教练课程信息包括预订信息
     * @param page
     * @param coachNumber
     * @return List<CoachClass>
     */
    public List<CoachClass> findByPage(Integer page,Integer coachNumber);

    /**
     * 总页数查询
     * @param coachNumber
     * @return mPage
     */
    public int findMaxPage(Integer coachNumber);

    /**
     * 添加课程
     * @param coachClass
     * @return int
     */
    public int insert(CoachClass coachClass);

    /**
     * 根据课程id查询课程
     * @param id
     * @return CoachClass
     */
    public CoachClass findById(Integer id);

    /**
     * 修改信息
     * @param coachClass
     * @return int
     */
    public int update(CoachClass coachClass);

    /**
     * 删除课程
     * @param coachClass
     * @return int
     */
    public int delete(CoachClass coachClass);

    /**
     * 截止报名
     * @param coachClass
     * @return int
     */
    public int end(CoachClass coachClass);

    /**
     * 课程完成消课
     * @param coachClass
     * @return int
     */
    public int finish(CoachClass coachClass);

    /**
     * 搜索课程
     * @param key
     * @return List<CoachClass>
     */
    public List<CoachClass> find(String key);
}
