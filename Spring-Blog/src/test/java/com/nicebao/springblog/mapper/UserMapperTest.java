package com.nicebao.springblog.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	void selectByName() {
		System.out.println(userMapper.selectByName("zhangsan"));
	}

	@Test
	void selectUserById() {
		System.out.println(userMapper.selectUserById(1));
	}
}