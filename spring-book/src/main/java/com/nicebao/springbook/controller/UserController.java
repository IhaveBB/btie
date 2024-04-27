package com.nicebao.springbook.controller;

import com.nicebao.springbook.constans.Constans;
import com.nicebao.springbook.model.UserInfo;
import com.nicebao.springbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.nicebao.springbook.constans.Constans.USER_SESSION_KEY;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public boolean login(String userName, String password, HttpSession session) {
		if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
			return false;
		}

		UserInfo userinfo = userService.queryByName(userName);
		if (userinfo == null) {
			return false;
		}
		if (password.equals(userinfo.getPassword())) {
			//清空session中的密码
			userinfo.setPassword("");
			session.setAttribute(USER_SESSION_KEY, userinfo);
			return true;
		}

		return false;
	}

}
