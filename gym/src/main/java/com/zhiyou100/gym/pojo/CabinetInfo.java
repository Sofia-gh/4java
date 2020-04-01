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
@TableName("cabinet_info")
public class CabinetInfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private Integer cabinetNumber;
    private int price;
    private int duration;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer memberNumber;
    private Integer status;
}
