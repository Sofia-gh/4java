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
@TableName("coach_class")
public class CoachClass implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer number;
    private Integer coachNumber;
    private String name;
    private String label;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer status;
    @TableField(exist = false)
    private CoachOrder coachOrder;
    @TableField(exist = false)
    private Coach coach;
}
