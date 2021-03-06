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
@TableName("staff_sign")
public class StaffSign implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private Timestamp  time;
    private Integer staffNumber;
    private String remark;
    private Integer status;
}
