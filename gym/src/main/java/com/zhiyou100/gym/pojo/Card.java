package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Sofia
 */
@Data
@TableName("card")
public class Card implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer number;
    private String type;
    private Integer price;
    @TableField("`describe`")
    private String describe;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
