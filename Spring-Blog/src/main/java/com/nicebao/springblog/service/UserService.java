package com.nicebao.springblog.service;

import com.nicebao.springblog.mapper.BlogMapper;
import com.nicebao.springblog.mapper.UserMapper;
import com.nicebao.springblog.model.BlogInfo;
import com.nicebao.springblog.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
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
		log.info("根据blogInfo获取到id"+blogInfo.getId());
		if (blogInfo==null && blogInfo.getUserId()<1){
			return null;
		}
		UserInfo userInfo = userMapper.selectUserById(blogInfo.getUserId());
		log.info(String.valueOf(userInfo.getId()));
		return userInfo;
	}
/**
 *
 *
 * @name: UserService
 * @author: IhaveBB
 * @date: 2024-04-15 22:10
 **/

}
