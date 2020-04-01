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
@TableName("prospect_sign")
public class ProspectSign implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private String name;
    private String sex;
    private Date birthday;
    private Long phone;
    private String profession;
    private String address;
    private String consult;
    private Timestamp  createTime;
    private Timestamp  updateTime;
    private Integer status;
}
