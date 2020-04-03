package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.ClassOrder;
import com.zhiyou100.gym.pojo.CoachOrder;

import java.util.List;

/**
 * @author Sofia
 */
public interface ICoachOrderService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 根据会员编号分页查询课程预定
     * @param page
     * @param coachOrder
     * @return List<CoachOrder>
     */
    public List<CoachOrder> findByPage(Integer page, CoachOrder coachOrder);

    /**
     * 根据会员编号查询课程预定总页数
     * @param coachOrder
     * @return mPage
     */
    public int findMaxPage(CoachOrder coachOrder);

    /**
     * 课程预定
     * @param coachOrder
     * @return int
     */
    public int insert(CoachOrder coachOrder);

    /**
     * 取消预订
     * @param coachOrder
     * @return int
     */
    public int delete(CoachOrder coachOrder);

    /**
     * 根据会员编号分页查询课程预定，多变联查
     * @param page
     * @param memberNumber
     * @return List<CoachOrder>
     */
    public List<CoachOrder> findByMemberNumber(Integer page, Integer memberNumber);

}
