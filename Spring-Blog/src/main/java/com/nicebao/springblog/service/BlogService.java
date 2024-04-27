package com.nicebao.springblog.service;

import com.nicebao.springblog.mapper.BlogMapper;
import com.nicebao.springblog.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService {
	@Autowired
	private BlogMapper blogMapper;
	public List<BlogInfo> queryBlogList() {
		return blogMapper.selectAllBlog();
	}
	public BlogInfo queryBlogDetail(Integer blogId) {
		return blogMapper.selectById(blogId);
	}
}
