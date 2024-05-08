package com.nicebao.springblog.controller;

import com.nicebao.springblog.constants.Constant;
import com.nicebao.springblog.model.BlogInfo;
import com.nicebao.springblog.service.BlogService;
import com.nicebao.springblog.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Slf4j
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
	public BlogInfo queryBlogDetail(Integer blogId,HttpServletRequest request){
		log.info("queryBlogDetail,接收参数blogId",+blogId);
		BlogInfo blogInfo = blogService.queryBlogDetail(blogId);
		//判断登陆用户是否是作者
		String user_token = request.getHeader(Constant.USER_TOKEN_HEADER);
		Integer userId = JWTUtils.getUserIdFromToken(user_token);

		if(userId != null && userId == blogInfo.getUserId()){
			blogInfo.setIsLoginUser(true);
		}else {
			blogInfo.setIsLoginUser(false);
		}
		return blogInfo;
	}
	@RequestMapping("/add")
	public boolean publishBlog(String title, String content, HttpServletRequest request){
		log.info("publishBlog.接收参数title:{},content:{}",title,content);
		if(!StringUtils.hasLength(title) || (!StringUtils.hasLength(content))){
			log.info("publishBlog接受参数长度错误");
			return false;
		}
		String user_token = request.getHeader(Constant.USER_TOKEN_HEADER);
		Integer userId = JWTUtils.getUserIdFromToken(user_token);
		log.info("userid:",userId);
		if(userId == null || userId < 0){
			log.info("用户未登录");
			return false;
		}
		BlogInfo blogInfo = new BlogInfo(title,content,userId);
		Integer result = blogService.publishBlog(blogInfo);
		if(result < 1){
			log.error("博客发布失败");
			return false;
		}
		return true;
	}

	@RequestMapping("/update")
	public Boolean update(Integer blogId,String title,String content){
		log.info("接收参数title:"+title+"接收参数content"+content);
		if(blogId == null || !StringUtils.hasLength(title) || !StringUtils.hasLength(content)){
			log.info("ID或标题或内容为空");
			return false;
		}
		BlogInfo blogInfo = new BlogInfo();
		blogInfo.setId(blogId);
		blogInfo.setTitle(title);
		blogInfo.setContent(content);
		Integer result = blogService.updateBlog(blogInfo);
		if(result != null){
			return true;
		}
		log.info("更新数据异常,service返回值为"+result);
		return false;
	}
	@RequestMapping("/delete")
	public Boolean delete(Integer blogId){
		log.info("deleteBlog  blogId:"+blogId);
		BlogInfo blogInfo = new BlogInfo();
		blogInfo.setId(blogId);
		blogInfo.setDeleteFlag(Constant.DELETE_FLAG);
		Integer result = blogService.updateBlog(blogInfo);
		if(result != null){
			return true;
		}
		log.info("删除博客异常,service返回值为"+result);
		return false;
	}
}
