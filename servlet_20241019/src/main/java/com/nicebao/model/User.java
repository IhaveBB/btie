package com.nicebao.model;

import lombok.Data;

import java.util.Date;

/**
 * @name: User
 * @author: IhaveBB
 * @date: 2024-10-19 22:19
 **/
@Data
public class User {
	private int id;
	private String username;
	private String password;
	private Date lastLoginTime;
	private String lastIp;
	private boolean isAdmin;
}
