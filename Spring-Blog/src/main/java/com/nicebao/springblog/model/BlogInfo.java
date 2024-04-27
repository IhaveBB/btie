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
	public String getCreateTime() {
		return DateUtils.formatDate(createTime);
	}
}

