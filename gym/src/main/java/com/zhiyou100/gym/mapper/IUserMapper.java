package com.zhiyou100.gym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Sofia
 */
@Mapper
public interface IUserMapper extends BaseMapper<User> {

	/**
	 * 多表关联查询
	 * @return List<User>
	 */
	@Select("select * from user")
	@Results({
		@Result(column="id",property="id",id=true),
		@Result(column="role_id",property="role",one=@One(fetchType=FetchType.EAGER,select="com.zhiyou100.gym.mapper.IRoleMapper.findById"))
	})
	public List<User> findAll();

	/**
	 * 根据用户名查询
	 * @param account
	 * @return User
	 */
	@Select("select * from user where account = #{account}")
	@Results({
		@Result(column="id",property="id",id=true),
		@Result(column="role_id",property="role",one=@One(fetchType=FetchType.EAGER,select="com.zhiyou100.gym.mapper.IRoleMapper.findById")),
		@Result(column="role_id",property="permissions",many=@Many(fetchType=FetchType.EAGER,select="com.zhiyou100.gym.mapper.IPermissionMapper.findByRoleId")),
	})
	public User findByAccount(String account);

}
