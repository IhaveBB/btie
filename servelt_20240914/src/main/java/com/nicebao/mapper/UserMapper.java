package com.nicebao.mapper;

import com.nicebao.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @name: UserMapper
 * @author: IhaveBB
 * @date: 2024-09-18 16:42
 **/
public interface UserMapper {
	int register(User user);
	User selectUserByName(@Param("userName") String userName);
}
