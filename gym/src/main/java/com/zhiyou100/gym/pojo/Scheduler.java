package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Sofia
 */
@Data
@TableName("scheduler")
public class Scheduler implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private Integer coachNumber;
    private String arrangement;
    private String unfinished;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
