package com.zhiyou100.gym.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou100.gym.mapper.IUserMapper;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	@Override
	public User findByAccount(String account) {
		if (StringUtils.isEmpty(account)) {
			return null;
		}
		return userMapper.findByAccount(account);
	}

	@Override
	public int findCurrentPage(Integer page) {
		if (page == null || page < 1) {
			page = 1;
		}
		return page;
	}

	@Override
	public List<User> findByPage(Integer page) {
		PageHelper.startPage(page,10);
		List<User> users = userMapper.findAll();
		return new PageInfo<User>(users).getList();
	}

	@Override
	public int findMaxPage() {
		int count = userMapper.selectCount(null);
		int mPage = count / 10;
		if (count % 10 != 0) {
			mPage ++;
		}
		return mPage;
	}

	@Override
	public int insert(User user) {
		String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(password);
		return userMapper.insert(user);
	}

	@Override
	public User findById(Integer id) {
		return userMapper.selectById(id);
	}

	@Override
	public int update(User user) {
		if (StringUtils.isEmpty(user.getPassword())) {
			String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
			user.setPassword(password);
		}
		return userMapper.updateById(user);
	}
	@Override
	public int delete(User user) {
		return userMapper.deleteById(user);
	}
}
