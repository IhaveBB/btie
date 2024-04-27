package com.nicebao.springbook.service;

import com.nicebao.springbook.mapper.UserInfoMapper;
import com.nicebao.springbook.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfo queryByName(String userName) {
		return userInfoMapper.queryByName(userName);
	}

}
