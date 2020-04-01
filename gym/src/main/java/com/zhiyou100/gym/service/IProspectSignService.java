package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.ProspectSign;

import java.util.List;

/**
 * @author Sofia
 */
public interface IProspectSignService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询潜客信息
     * @param page
     * @return List<ProspectSign>
     */
    public List<ProspectSign> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 潜客登记
     * @param prospectSign
     * @return int
     */
    public int insert(ProspectSign prospectSign);
}
