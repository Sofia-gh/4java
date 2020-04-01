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
@TableName("member_sign")
public class MemberSign implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private Timestamp  inTime;
    private Timestamp  outTime;
    private Integer memberNumber;
    private Integer status;
}
