package com.nicebao.model;
import lombok.Data;

import java.sql.Date;


/**
 * @name: LeaveRequest
 * @author: IhaveBB
 * @date: 2024-09-03 22:29
 **/
@Data
public class LeaveRequest {
	private String studentName;
	private String studentId;
	private String contact;
	private String leaveReason;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String proofFilePath;


}
