package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Sofia
 */
@Mapper
public interface ICardMapper extends BaseMapper<Card> {

    /**
     * 根据number查询
     * @param number
     * @return Card
     */
    @Select("select c.* from card c where number = ${number}")
    public Card findByNumber(Integer number);
}
