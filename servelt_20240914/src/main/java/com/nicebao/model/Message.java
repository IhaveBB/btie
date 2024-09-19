package com.nicebao.model;

import lombok.Data;

import java.util.Date;

/**
 * @name: Message
 * @author: IhaveBB
 * @date: 2024-09-15 21:56
 **/
@Data
public class Message {
	private String userName;
	private String content;
	private Date createdAt;
}

