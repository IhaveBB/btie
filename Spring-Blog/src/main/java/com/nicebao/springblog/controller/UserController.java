package com.nicebao.springblog.controller;

import com.nicebao.springblog.constants.Constant;
import com.nicebao.springblog.model.BlogInfo;
import com.nicebao.springblog.model.Result;
import com.nicebao.springblog.model.UserInfo;
import com.nicebao.springblog.service.UserService;
import com.nicebao.springblog.utils.JWTUtils;
import com.nicebao.springblog.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public Result login(String userName, String password){
		//1.参数校验
		//2.对密码进行校验
		//3.校验成功生成token
		if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
			return Result.fail("用户名或密码不能为空");
		}

		UserInfo userInfo = userService.queryUserByName(userName);
		if(userInfo == null || userInfo.getId() < 0){
			return Result.fail("用户不存在");
		}


//		if(!password.equals(userInfo.getPassword())){
//			return Result.fail("密码错误");
//		}
		if (!SecurityUtils.verify(password, userInfo.getPassword())){
			return Result.fail("密码错误");
		}
		Map<String,Object> map = new HashMap<>();
		map.put(Constant.USER_CLAIM_ID,userInfo.getId());
		map.put(Constant.USER_CLAIM_NAME,userInfo.getUserName());
		String token = JWTUtils.getToken(map);
		log.info("用户名密码校验成功，token获得成功，getToken:"+token);
		return Result.success(token);
	}

	/** @description: 根基token获取当前用户信息
			* @param: com.nicebao.springblog.model.UserInfo
			* @return: com.nicebao.springblog.model.UserInfo
			* @author: IhaveBB
			* @date: 2024/4/27
			*/
	@RequestMapping("/getUserInfo")
	public UserInfo getUserInfo(HttpServletRequest request){
		String token = request.getHeader(Constant.USER_TOKEN_HEADER);
		Integer userId = JWTUtils.getUserIdFromToken(token);
		if(userId == null && userId <=0 ){
			return null;
		}
		return userService.queryUserInfoById(userId);
	}
	/** @description: 根据博客ID获取作者信息
			* @param: com.nicebao.springblog.model.UserInfo
			* @return: com.nicebao.springblog.model.UserInfo
			* @author: IhaveBB
			* @date: 2024/4/27
			*/
	@RequestMapping("/getAuthorInfo")
	public UserInfo getAuthorInfo(Integer blogId){
		if(blogId < 1 && blogId == null){
			log.info("接收到blogId"+blogId);
			return null;
		}
		log.info("接收到blogId"+blogId);
		return userService.getAuthorInfoByBlogId(blogId);
	}
}
