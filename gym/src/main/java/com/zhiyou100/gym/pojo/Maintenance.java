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
@TableName("maintenance")
public class Maintenance implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private String area;
    private String name;
    private Integer equipmentNumber;
    @TableField("`describe`")
    private String describe;
    private Integer price;
    private String cause;
    private String person;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
