package com.nicebao.Bean;

import lombok.Data;

import java.util.Date;

/**
 * @name: LoginLog
 * @author: IhaveBB
 * @date: 2024-10-20 11:40
 **/

public class LoginLog {
	private int userId;
	private Date loginTime;
	private String loginIp;

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
