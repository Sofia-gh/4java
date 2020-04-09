package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Sofia
 */
@Data
@TableName("role")
public class Role implements Serializable {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String name;
//	@TableField(exist = false)
//	private List<Permission> permissions;
}
