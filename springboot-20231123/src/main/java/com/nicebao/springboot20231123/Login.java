package com.nicebao.springboot20231123;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@RestController
public class Login {
	@RequestMapping("/check")
	public boolean check(String username, String password, HttpSession httpSession){
		System.out.println("接收到参数"+username+" "+password);
		//校验账号密码是否为空
		if(!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
			return false;
		}
		//校验账号密码是否正确
		//常亮卸载前面，变量写在后面，防止空指针异常
		if("zhangsan".equals(username) && "123456".equals(password)){
			httpSession.setAttribute("username",username);
			return true;
		}
		return false;
	}
	@RequestMapping("/index")
	public String check(HttpSession httpSession){
		String username = (String) httpSession.getAttribute("username");
		return username;
	}
}
