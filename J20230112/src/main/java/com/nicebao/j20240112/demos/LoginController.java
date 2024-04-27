package com.nicebao.j20240112.demos;

import org.apache.catalina.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@RestController
public class LoginController {
	@RequestMapping("/check")
	public boolean check(String userName, String password, HttpSession session){
		//检查字符串不为空也不为null
		if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
			return false;
		}
		else if("zhangsan".equals(userName) && "123456".equals(password)){
			session.setAttribute("username",userName);
			return true;
		}
		return false;
	}
	@RequestMapping("/index")
	//
	public String index(HttpSession session){
		String username = (String) session.getAttribute("username");
		return username;
	}

}
