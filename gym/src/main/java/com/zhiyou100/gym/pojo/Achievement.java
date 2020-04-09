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
@TableName("achievement")
public class Achievement implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private Integer coachNumber;
    private Integer memberNumber;
    private String type;
    private Integer price;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
