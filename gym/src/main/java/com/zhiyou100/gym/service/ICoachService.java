package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Coach;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Sofia
 */
public interface ICoachService {
    /**
     * 对当前页面参数处理
     * @param page
     * @return currentPage
     */
    public int findCurrentPage(Integer page);

    /**
     * 分页查询教练信息
     * @param page
     * @param key
     * @return List<Coach>
     */
    public List<Coach> findByPage(Integer page,String key);

    /**
     * 总页数查询
     * @param key
     * @return mPage
     */
    public int findMaxPage(String key);

    /**
     * 添加教练信息
     * @param file
     * @param coach
     * @return int
     */
    public int insert(Coach coach, MultipartFile file);

    /**
     * 根据id查询教练信息
     * @param id
     * @return
     */
    public Coach findById(Integer id);

    /**
     * 修改教练信息
     * @param file
     * @param coach
     * @return int
     */
    public int update(Coach coach,MultipartFile file);

}
