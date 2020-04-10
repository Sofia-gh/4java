package com.zhiyou100.gym.service.impl;

import java.util.List;

import com.zhiyou100.gym.mapper.IRoleMapper;
import com.zhiyou100.gym.pojo.Role;
import com.zhiyou100.gym.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleMapper roleMapper;

	@Override
	public List<Role> findAll() {
		return roleMapper.selectList(null);
	}
}
