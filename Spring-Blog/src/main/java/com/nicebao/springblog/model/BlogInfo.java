package com.nicebao.springblog.model;


import com.nicebao.springblog.utils.DateUtils;
import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {
/**
 *
 *
 * @name: BlogInfo
 * @author: IhaveBB
 * @date: 2024-04-11 18:45
 **/
	private Integer id;
	private String title;
	private String content;
	private Integer userId;
	private Integer deleteFlag;
	private Date createTime;
	private Date updateTime;
	private Boolean isLoginUser;

	public String getCreateTime() {
		return DateUtils.formatDate(createTime);
	}

	public BlogInfo(String title, String content, Integer userId) {
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public BlogInfo() {
	}

}


