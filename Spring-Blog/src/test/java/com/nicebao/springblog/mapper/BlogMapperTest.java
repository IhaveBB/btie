package com.nicebao.springblog.mapper;

import com.nicebao.springblog.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogMapperTest {
@Autowired
private BlogMapper blogMapper;

	@Test
	void selectAllBlog() {
		System.out.println(blogMapper.selectAllBlog());
	}

	@Test
	void selectById() {
		System.out.println(blogMapper.selectById(1));
	}

	@Test
	void updateBlog() {
		BlogInfo blogInfo = new BlogInfo();
		blogInfo.setId(1);
		blogInfo.setTitle("测试更新");
		blogInfo.setContent("测试内容更新");
		System.out.println(blogMapper.updateBlog(blogInfo));
	}

	@Test
	void insetBlog() {
		BlogInfo blogInfo = new BlogInfo();
		blogInfo.setId(3);
		blogInfo.setTitle("测试插入");
		blogInfo.setContent("测试内容插入");
		System.out.println(blogMapper.insetBlog(blogInfo));
	}

	@Test
	void deleteBlog() {
		BlogInfo blogInfo = new BlogInfo();
		blogInfo.setId(1);
		blogInfo.setDeleteFlag(1);
		System.out.println(blogMapper.updateBlog(blogInfo));
	}
}