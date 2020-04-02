package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Class;

import java.util.List;

/**
 * @author Sofia
 */
public interface IClassService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询团课信息
     * @param page
     * @return List<Class>
     */
    public List<Class> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 添加团课
     * @param c
     * @return int
     */
    public int insert(Class c);

    /**
     * 开始团课
     * @param c
     * @return int
     */
    public int start(Class c);

    /**
     * 结束团课
     * @param c
     * @return int
     */
    public int end(Class c);

    /**
     * 搜索团课
     * @param key
     * @return List<Class>
     */
    public List<Class> find(String key);
}
