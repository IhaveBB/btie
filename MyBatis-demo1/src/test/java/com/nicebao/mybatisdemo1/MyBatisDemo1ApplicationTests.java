package com.nicebao.mybatisdemo1;

import com.nicebao.mybatisdemo1.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisDemo1ApplicationTests {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Test
	void contextLoads() {
		System.out.println(userInfoMapper.queryUserList());
	}

}
