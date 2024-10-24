package com.nicebao.springboot20241031.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name: User
 * @author: IhaveBB
 * @date: 2024-10-21 17:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Long id;
	private String username;
	private String password;
}
