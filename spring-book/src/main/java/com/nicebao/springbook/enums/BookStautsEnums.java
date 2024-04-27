package com.nicebao.springbook.enums;

import org.apache.ibatis.annotations.Case;

public enum BookStautsEnums {
	DELETE(0, "无效"),
	NORMAL(1, "可借阅"),
	FORBIDDEN(2, "不可借阅"),
	;

	private int code;
	private String desc;

	BookStautsEnums(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	//根据状态获取描述
	public static BookStautsEnums getDescByCode(int code) {
		switch (code) {
			case 0:
				return BookStautsEnums.DELETE;
			case 1:
				return BookStautsEnums.NORMAL;
			case 2:
				return BookStautsEnums.FORBIDDEN;
		}
		return BookStautsEnums.DELETE;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
