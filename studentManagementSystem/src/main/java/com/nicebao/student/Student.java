package com.nicebao.student;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	/**
	 * 学生类
	 *
	 * @name: Student
	 * @author: IhaveBB
	 * @date: 2023-11-24 21:24
	 **/
	private long studentId;
	private String name;
	private String gender;
	private String birthdate;
	private String address;
	private String phoneNumber;

	// 构造函数、getter、setter、toString
	public Student(){}

	public Student(long studentId, String name, String gender, String birthdate, String address, String phoneNumber) {
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Student{" + "\n" +
				"  学号=" + studentId + "\n" +
				", 姓名='" + name + '\'' + "\n" +
				", 性别='" + gender + '\'' + "\n" +
				", 生日='" + birthdate + '\'' + "\n" +
				", 住址='" + address + '\'' + "\n" +
				", 手机号='" + phoneNumber + '\'' + "\n" +
				'}';
	}
	/** @description: 数据库中生日类为Date，格式要求为yyyy-MM-dd。
	 * 故此方法为判断日期是否符合格式，若不符合则使用默认值，并提示错误，要求用户进行和修改。
	 * @param: String
	 * @return: String
	 * @author: IhaveBB
	 * @date: 2023/11/27
	 */
	public static String fixBirthdate(String birthdate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		// 设置严格解析日期
		dateFormat.setLenient(false);
		try {
			Date date = dateFormat.parse(birthdate);
			//正确不进行修改
			return birthdate;
		} catch (ParseException e) {
			System.out.println("生日日期格式日常" + e.getMessage());
			return "1970/01/01";
		}
	}
}

