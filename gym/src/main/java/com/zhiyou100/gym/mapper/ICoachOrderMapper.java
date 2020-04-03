package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.CoachOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Sofia
 */
@Mapper
public interface ICoachOrderMapper extends BaseMapper<CoachOrder> {

    /**
     * findByCoachClassNumber
     * @param number
     * @return CoachOrder
     */
    @Select("select * from coach_order where coach_class_number = ${number}")
    public CoachOrder findByCoachClassNumber(Integer number);

    /**
     * 多表联查会员预定课程
     * @param memberNumber
     * @return
     */
    @Select("select * from coach_order where member_number = ${memberNumber}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "coach_class_number",property = "coachClass",one = @One(fetchType = FetchType.EAGER,select = "com.zhiyou100.gym.mapper.ICoachClassMapper.findByNumber"))
    })
    public List<CoachOrder> selectPageByMemberNumber(Integer memberNumber);
}
