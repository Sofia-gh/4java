package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Sofia
 */
@Data
@TableName("coach_order")
public class CoachOrder implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long number;
    private Integer coachClassNumber;
    private Integer memberNumber;
    private Integer status;
    private CoachClass coachClass;
}
