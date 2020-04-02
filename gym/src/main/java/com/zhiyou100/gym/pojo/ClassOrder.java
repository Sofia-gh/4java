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
@TableName("class_order")
public class ClassOrder implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private Integer classNumber;
    private Integer memberNumber;
    private Integer status;
    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private String type;
    @TableField(exist = false)
    private Timestamp startTime;
    @TableField(exist = false)
    private Timestamp endTime;
    @TableField(exist = false)
    private String coach;
    @TableField(exist = false)
    private Integer cStatus;
}
