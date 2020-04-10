package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.ClassOrder;

import java.util.List;

/**
 * @author Sofia
 */
public interface IClassOrderService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 根据团课编号分页查询团课预定
     * @param page
     * @param classOrder
     * @return List<ClassOrder>
     */
    public List<ClassOrder> findByPage(Integer page,ClassOrder classOrder);

    /**
     * 根据会员或者团课编号查询团课预定总页数
     * @param classOrder
     * @return mPage
     */
    public int findMaxPage(ClassOrder classOrder);

    /**
     * 团课预定
     * @param classOrder
     * @return int
     */
    public int insert(ClassOrder classOrder);

    /**
     * 取消预订
     * @param classOrder
     * @return int
     */
    public int delete(ClassOrder classOrder);

    /**
     * 根据会员编号分页查询团课预定
     * @param page
     * @param memberNumber
     * @return List<ClassOrder>
     */
    public List<ClassOrder> findByMemberNumber(Integer page,Integer memberNumber);

}
