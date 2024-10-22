package com.nicebao.model;

import lombok.Data;

/**
 * @name: LoginResult
 * @author: IhaveBB
 * @date: 2024-10-20 11:53
 **/

@Data
public class LoginResult {
	private boolean success;
	private User user;
	private String errorMessage;

	public LoginResult(String errorMessage, boolean success, User user) {
		this.errorMessage = errorMessage;
		this.success = success;
		this.user = user;
	}

	public LoginResult(boolean success, String errorMessage) {
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public LoginResult(boolean success,User user) {
		this.user = user;
		this.success = success;
	}
}
