package com.nicebao.model;

import lombok.Data;

import java.util.Date;

/**
 * @name: UserActionLog
 * @author: IhaveBB
 * @date: 2024-10-21 14:31
 **/
@Data
public class UserActionLog {
	private int id;
	private int userId;
	private Date actionTime;
	private String ip;
	private String url;
}
