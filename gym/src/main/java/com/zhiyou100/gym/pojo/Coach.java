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
@TableName("coach")
public class Coach implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer number;
    private String name;
    private String sex;
    private Integer age;
    private Long phone;
    private String label;
    private String picture;
    private String introduce;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer status;
}
