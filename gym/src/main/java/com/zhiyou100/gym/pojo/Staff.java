package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Sofia
 */
@Data
@TableName("staff")
public class Staff implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer number;
    private String name;
    private String sex;
    private Date birthday;
    private Long phone;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
