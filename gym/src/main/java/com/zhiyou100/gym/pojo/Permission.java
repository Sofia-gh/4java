package com.zhiyou100.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Sofia
 */
@Data
@TableName("permission")
public class Permission {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String name;
}
