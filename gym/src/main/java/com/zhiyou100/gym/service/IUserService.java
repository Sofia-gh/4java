package com.zhiyou100.gym.service;

import java.util.List;

import com.zhiyou100.gym.pojo.User;

/**
 * @author Sofia
 */
public interface IUserService {
	/**
	 * 对当前页面参数处理
	 * @param page
	 * @return currentPage
	 */
	public int findCurrentPage(Integer page);

	/**
	 * 分页查询用户信息
	 * @param page
	 * @return List<User>
	 */
	public List<User> findByPage(Integer page);

	/**
	 * 总页数查询
	 * @return mPage
	 */
	public int findMaxPage();

	/**
	 * 添加用户
	 * @param user
	 * @return int
	 */
	public int insert(User user);

	/**
	 * 根据account查询用户信息
	 * @param account
	 * @return User
	 */
	public User findByAccount(String account);

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return User
	 */
	public User findById(Integer id);

	/**
	 * 修改用户信息
	 * @param user
	 * @return int
	 */
	public int update(User user);

	/**
	 * 删除用户信息
	 * @param user
	 * @return int
	 */
	public int delete(User user);
}
