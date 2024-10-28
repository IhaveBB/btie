package com.nicebao.model;

import lombok.Data;

import java.util.Date;

/**
 * @name: LoginLog
 * @author: IhaveBB
 * @date: 2024-10-20 11:40
 **/
@Data
public class LoginLog {
	private int userId;
	private Date loginTime;
	private String loginIp;
}
