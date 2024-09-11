package com.nicebao.model;

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
	private Date predictLeaveTime;
	private Date predictReturnTime;
	private Date submitTime;
	private Date updateTime;
	private String status;
	private String proofPath;
}
