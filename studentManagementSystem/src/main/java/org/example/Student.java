package org.example;

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
}

