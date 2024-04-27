package com.nicebao.springblog.mapper;


import com.nicebao.springblog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	/** @description: 根据用户名查询信息
			* @param: com.nicebao.springblog.model.UserInfo
			* @return: com.nicebao.springblog.model.UserInfo
			* @author: IhaveBB
			* @date: 2024/4/12
			*/
	@Select("select * from user where user_name = #{userName} and delete_flag = 0")
	UserInfo selectByName(String userName);

	/** @description: 根据用户ID查询信息
			* @param: com.nicebao.springblog.model.UserInfo
			* @return: com.nicebao.springblog.model.UserInfo
			* @author: IhaveBB
			* @date: 2024/4/12
			*/
	@Select("select * from user where id = #{userId} and delete_flag = 0")
	UserInfo selectUserById(Integer userId);
}
