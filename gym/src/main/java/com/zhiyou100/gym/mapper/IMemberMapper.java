package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.CoachClass;
import com.zhiyou100.gym.pojo.Member;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Sofia
 */
@Mapper
public interface IMemberMapper extends BaseMapper<Member> {

    /**
     * 多表关联根据查询会员信息
     * @param key
     * @return List<Member>
     */
    @Select("select * from member m left join card c on card_number = c.number where m.name like concat('%',#{key},'%') or c.type like concat('%',#{key},'%')")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "card_number",property = "card",one = @One(fetchType= FetchType.EAGER,select="com.zhiyou100.gym.mapper.ICardMapper.findByNumber"))
    })
    public List<Member> find(String key);

    /**
     * 多表关联根据查询会员信息数量
     * @param key
     * @return int
     */
    @Select("select count(m.id) from member m left join card c on card_number = c.number where m.name like concat('%',#{key},'%') or c.type like concat('%',#{key},'%')")
    public int findCount(String key);

    /**
     * 多表关联根据查询会员信息
     * @return List<Member>
     */
    @Select("select * from member")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "card_number",property = "card",one = @One(fetchType= FetchType.EAGER,select="com.zhiyou100.gym.mapper.ICardMapper.findByNumber"))
    })
    public List<Member> findAll();

    /**
     * 根据会员编号查询会员信息
     * @param number
     * @return Member
     */
    @Select("select * from member where number = ${number}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "card_number",property = "card",one = @One(fetchType= FetchType.EAGER,select="com.zhiyou100.gym.mapper.ICardMapper.findByNumber"))
    })
    public Member findByNumber(Integer number);
}
