package com.nicebao.springbook.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Component
public class BookInfo {
	private Integer id;
	private String bookName;
	private String author;
	private Integer count;
	private BigDecimal price;
	private String publish;
	private Integer status;
	private String stateCN;
	private Date createTime;
	private Date updateTime;
}
