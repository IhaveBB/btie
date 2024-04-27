package com.nicebao.mybatisdemo1.model;
import lombok.Data;

import java.awt.*;
import java.util.Date;

@Data
public class UserInfo {
/**
 *
 *
 * @name: UserInfo
 * @author: IhaveBB
 * @date: 2024-01-23 17:50
 **/
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private Integer gender;
	private String phone;
	private Integer deleteFlag;
	private Date createTime;
	private Date updateTime;
}
