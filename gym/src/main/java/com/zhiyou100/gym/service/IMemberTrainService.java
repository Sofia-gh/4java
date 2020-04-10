package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.MemberTrain;

import java.util.List;

/**
 * @author Sofia
 */
public interface IMemberTrainService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询会员训练记录
     * @param number
     * @param page
     * @return List<MemberTrain>
     */
    public List<MemberTrain> findByPage(Integer page,Integer number);

    /**
     * 总页数查询
     * @param number
     * @return mPage
     */
    public int findMaxPage(Integer number);

    /**
     * 开始训练
     * @param memberTrain
     * @return int
     */
    public int insert(MemberTrain memberTrain);

    /**
     * 结束训练
     * @param memberTrain
     * @return int
     */
    public int update(MemberTrain memberTrain);

    /**
     * 查询全部
     * @param number
     * @return List<Long>
     */
    public List<Double> findAll(Integer number);
}
