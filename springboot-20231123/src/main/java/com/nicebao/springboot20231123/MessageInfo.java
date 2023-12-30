package com.nicebao.springboot20231123;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageInfo {
	private String from;
	private  String to;
	private String message;
}
