package com.nicebao.springblog.model;

import lombok.Data;
import java.util.Date;

@Data
public class UserInfo {
/**
 *
 *
 * @name: UserInfo
 * @author: IhaveBB
 * @date: 2024-04-11 18:45
 **/
	private Integer id;
	private String userName;
	private String password;
	private String githubUrl;
	private Date createTime;
	private Date updateTime;

}
