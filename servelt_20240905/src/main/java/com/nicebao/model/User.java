package com.nicebao.model;

import lombok.Data;

/**
 * @name: User
 * @author: IhaveBB
 * @date: 2024-09-03 12:17
 **/
@Data
public class User {
	private String username;
	private String password;
	private String userId;
	private String phone;
	private String email;
	private Integer isDelete;
}
