package com.zhiyou100.gym.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

/**
 * @author Sofia
 */
@Mapper
public interface IRoleMapper extends BaseMapper<Role>{

	/**
	 * 根据userId查询角色
	 * @param id
	 * @return Role
	 */
	@Select("select * from role where id = #{id}")
	public Role findById(int id);
}
