package com.nicebao.model;

import lombok.Data;

import java.util.Date;

/**
 * @name: OperationLog
 * @author: IhaveBB
 * @date: 2024-10-21 15:42
 **/
@Data
public class OperationLog {
	private int userId;
	private Date actionTime;
	private String url;
	private String ip;
}
