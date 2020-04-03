package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.Coach;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * @author Sofia
 */
@Mapper
public interface ICoachMapper extends BaseMapper<Coach> {

    /**
     * 根据number查询
     * @param number
     * @return Coach
     */
    @Select("select c.name,c.phone from coach c where number = ${number}")
    public Coach findByNumber(Integer number);
}
