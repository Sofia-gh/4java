package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.CoachClass;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Sofia
 */
@Mapper
public interface ICoachClassMapper extends BaseMapper<CoachClass> {
    /**
     * 多表关联根据教练编号查询教练课程信息
     * @param coachNumber
     * @return List<CoachClass>
     */
    @Select("select * from coach_class where coach_number = ${coachNumber} order by status")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "number",property = "number"),
            @Result(column = "number",property = "coachOrder",one = @One(fetchType= FetchType.EAGER,select="com.zhiyou100.gym.mapper.ICoachOrderMapper.findByCoachClassNumber"))
    })
    public List<CoachClass> findByCoachNumber(Integer coachNumber);

    /**
     * 多表关联根据教练编号查询教练课程信息
     * @return List<CoachClass>
     */
    @Select("select * from coach_class order by status")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "number",property = "number"),
            @Result(column = "number",property = "coachOrder",one = @One(fetchType= FetchType.EAGER,select="com.zhiyou100.gym.mapper.ICoachOrderMapper.findByCoachClassNumber"))
    })
    public List<CoachClass> find();

    /**
     * 根据number查询
     * @param number
     * @return CoachClass
     */
    @Select("select * from coach_class where number = ${number}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "coach_number",property = "coach",one = @One(fetchType= FetchType.EAGER,select="com.zhiyou100.gym.mapper.ICoachMapper.findByNumber"))
    })
    public CoachClass findByNumber(Integer number);
}
