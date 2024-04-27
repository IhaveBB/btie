package com.nicebao.mybatisdemo1.mapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.junit.jupiter.api.Assertions.*;

class UserInfoMapperTest {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void queryUserList() {
	}

	@Test
	void queryUserInfo() {
	}

	@Test
	void testQueryUserInfo() {
		System.out.println(userInfoMapper.queryUserInfo(1).toString());
	}
}