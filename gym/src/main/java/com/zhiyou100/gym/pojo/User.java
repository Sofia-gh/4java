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
@TableName("user")
public class User implements Serializable {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String account;
	private String password;
	private Integer number;
	private Integer roleId;
	@TableField(exist = false)
	private Role role;
	@TableField(exist = false)
	private List<Permission> permissions;
}
