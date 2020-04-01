package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Cabinet;
import com.zhiyou100.gym.pojo.CabinetInfo;

import java.util.List;

/**
 * @author Sofia
 */
public interface ICabinetInfoService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询租柜记录
     * @param page
     * @return List<CabinetInfo>
     */
    public List<CabinetInfo> findByPage(Integer page);

    /**
     * 总页数查询
     * @return mPage
     */
    public int findMaxPage();

    /**
     * 租柜
     * @param cabinetInfo
     * @return 0/1
     */
    public int insert(CabinetInfo cabinetInfo);
}
