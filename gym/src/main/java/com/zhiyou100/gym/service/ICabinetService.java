package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Cabinet;

import java.util.List;

/**
 * @author Sofia
 */
public interface ICabinetService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询柜子信息
     * @param page
     * @return List<Cabinet>
     */
    public List<Cabinet> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 添加柜子
     * @param cabinet
     * @return 0/1
     */
    public int insert(Cabinet cabinet);
}
