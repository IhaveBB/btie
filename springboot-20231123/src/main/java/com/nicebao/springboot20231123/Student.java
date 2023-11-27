package com.nicebao.springboot20231123;

public class Student {
/**
 *
 *
 * @name: Student
 * @author: IhaveBB
 * @date: 2023-11-26 21:02
 **/
	private Integer age;
	private String gender;
	private String name;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"age=" + age +
				", gender='" + gender + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
