package com.nicebao.springblog.controller;

import com.nicebao.springblog.model.BlogInfo;
import com.nicebao.springblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/blog")
@RestController
public class BlogController {
	@Autowired
	private BlogService blogService;


	/** @description: 查询全部博客
			* @param: java.util.List<com.nicebao.springblog.model.BlogInfo>
			* @return: java.util.List<com.nicebao.springblog.model.BlogInfo>
			* @author: IhaveBB
			* @date: 2024/4/17
			*/
	@RequestMapping("/getList")
	public List<BlogInfo> queryBlogList(){
		return blogService.queryBlogList();
	}
	/** @description: 根据ID查询具体博客内容
			* @param: com.nicebao.springblog.model.BlogInfo
			* @return: com.nicebao.springblog.model.BlogInfo
			* @author: IhaveBB
			* @date: 2024/4/17
			*/
	@RequestMapping("/queryBlogDetail")
	public BlogInfo queryBlogDetail(Integer blogId){
		return blogService.queryBlogDetail(blogId);
	}
}
