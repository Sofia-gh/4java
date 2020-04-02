package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhiyou100.gym.pojo.ClassOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Sofia
 */
@Mapper
public interface IClassOrderMapper extends BaseMapper<ClassOrder> {
    /**
     * 多表关联查询预订课程
     * @param memberNumber
     * @return List<ClassOrder>
     */
    @Select("select co.*,c.name,c.type,c.start_time,c.end_time,c.coach,c.status cstatus from class_order co inner join class c on c.number = class_number where member_number = ${memberNumber}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "cstatus",property = "cStatus")

    })
    public List<ClassOrder> selectPageByMemberNumber(Integer memberNumber);
}
