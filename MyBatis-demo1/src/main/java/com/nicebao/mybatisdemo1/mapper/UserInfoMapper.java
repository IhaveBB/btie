package com.nicebao.mybatisdemo1.mapper;

import com.nicebao.mybatisdemo1.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {
/** @description: 返回数据列表
		* @param: java.util.List<com.nicebao.mybatisdemo1.model.UserInfo>
		* @return: java.util.List<com.nicebao.mybatisdemo1.model.UserInfo>
		* @author: IhaveBB
		* @date: 2024/1/23
		*/
	@Select("select * from  userinfo")
	List<UserInfo> queryUserList();

	@Select("select * from userinfo where id = #{userId}")
	UserInfo queryUserInfo(Integer userId);

}
