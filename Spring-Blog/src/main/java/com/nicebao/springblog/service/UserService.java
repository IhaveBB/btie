package com.nicebao.springblog.service;

import com.nicebao.springblog.mapper.BlogMapper;
import com.nicebao.springblog.mapper.UserMapper;
import com.nicebao.springblog.model.BlogInfo;
import com.nicebao.springblog.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BlogMapper blogMapper;
	public UserInfo queryUserByName(String userName) {
		return userMapper.selectByName(userName);
	}

	public UserInfo queryUserInfoById(Integer userId) {
		return userMapper.selectUserById(userId);
	}

	public UserInfo getAuthorInfoByBlogId(Integer blogId) {
		BlogInfo blogInfo = blogMapper.selectById(blogId);
		if(blogInfo == null && blogInfo.getUserId() < 1){
			return null;
		}
		return userMapper.selectUserById(blogInfo.getUserId());
	}
/**
 *
 *
 * @name: UserService
 * @author: IhaveBB
 * @date: 2024-04-15 22:10
 **/

}
