package com.zhiyou100.gym.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyou100.gym.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Sofia
 */
@Mapper
public interface IPermissionMapper extends BaseMapper<Permission> {

	/**
	 * 根据roleId查询权限
	 * @param roleId
	 * @return List<Permission>
	 */
	@Select("select p.* from permission p inner join role_permission rp on p.id = rp.permission_id where rp.role_id = #{roleId}")
	public List<Permission> findByRoleId(int roleId);

}
