package com.nicebao.springbook.mapper;

import com.nicebao.springbook.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
	@Select("select * from user_info where delete_flag=0 and user_name = #{userName}")
	UserInfo queryByName(String userName);
}
