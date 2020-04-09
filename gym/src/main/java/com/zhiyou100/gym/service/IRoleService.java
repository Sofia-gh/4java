package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Role;

import java.util.List;

public interface IRoleService {
	/**
	 * 查询角色
	 * @return List<Role>
	 */
	public List<Role> findAll();
}
