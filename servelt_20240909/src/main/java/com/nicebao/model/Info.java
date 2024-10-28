package com.nicebao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;


/**
 * @name: Info
 * @author: IhaveBB
 * @date: 2024-09-09 19:55
 **/
@Data
public class Info {
	private String name;
	private String studentId;
	private String phoneNumber;
	private String leaveReason;
	//防止jackson序列化时，将data转为时间戳
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date predictLeaveTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date predictReturnTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date submitTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
	private Date updateTime;
	private String status;
	private String proofPath;
}
