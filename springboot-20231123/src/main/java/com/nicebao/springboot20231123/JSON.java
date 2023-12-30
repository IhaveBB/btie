package com.nicebao.springboot20231123;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;

public class JSON {
	public static void main(String[] args) throws JsonProcessingException {
		 ObjectMapper objectMapper = new ObjectMapper();
		Student student = new Student();
		student.setAge(18);
		student.setName("daw");
		student.setGender("男");
		//对象转json
		String s = objectMapper.writeValueAsString(student);
		System.out.println(s);

		//json转字符串
		Student student1 = objectMapper.readValue(s,Student.class);
		System.out.println(student1);


	}


}
