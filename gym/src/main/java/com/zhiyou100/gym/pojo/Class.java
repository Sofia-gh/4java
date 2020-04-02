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
@TableName("class")
public class Class implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer number;
    private String name;
    private String type;
    private Timestamp startTime;
    private Timestamp endTime;
    private String coach;
    private Integer status;
}
