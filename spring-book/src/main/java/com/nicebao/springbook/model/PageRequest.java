package com.nicebao.springbook.model;

import lombok.Data;

import java.util.List;
@Data
public class PageRequest<T> {
	private Integer currPage = 1;
	private Integer pageSize = 10;
	private Integer offset = 1;

	public Integer getOffSet(){
		return (currPage - 1) * pageSize;
	}


}
