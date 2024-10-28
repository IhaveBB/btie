package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 商品退货
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-04-02 11:00:00
 */
@TableName("shangpintuihuo")
public class ShangpintuihuoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShangpintuihuoEntity() {
		
	}
	
	public ShangpintuihuoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 供应商编号
	 */
					
	private String gongyingshangbianhao;
	
	/**
	 * 供应商名称
	 */
					
	private String gongyingshangmingcheng;
	
	/**
	 * 采购编号
	 */
					
	private String caigoubianhao;
	
	/**
	 * 商品编号
	 */
					
	private String shangpinbianhao;
	
	/**
	 * 商品名称
	 */
					
	private String shangpinmingcheng;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 采购价格
	 */
					
	private Integer caigoujiage;
	
	/**
	 * 退货金额
	 */
					
	private Integer tuihuojine;
	
	/**
	 * 退货原因
	 */
					
	private String tuihuoyuanyin;
	
	/**
	 * 退货日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date tuihuoriqi;
	
	/**
	 * 员工工号
	 */
					
	private String yuangonggonghao;
	
	/**
	 * 员工姓名
	 */
					
	private String yuangongxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：供应商编号
	 */
	public void setGongyingshangbianhao(String gongyingshangbianhao) {
		this.gongyingshangbianhao = gongyingshangbianhao;
	}
	/**
	 * 获取：供应商编号
	 */
	public String getGongyingshangbianhao() {
		return gongyingshangbianhao;
	}
	/**
	 * 设置：供应商名称
	 */
	public void setGongyingshangmingcheng(String gongyingshangmingcheng) {
		this.gongyingshangmingcheng = gongyingshangmingcheng;
	}
	/**
	 * 获取：供应商名称
	 */
	public String getGongyingshangmingcheng() {
		return gongyingshangmingcheng;
	}
	/**
	 * 设置：采购编号
	 */
	public void setCaigoubianhao(String caigoubianhao) {
		this.caigoubianhao = caigoubianhao;
	}
	/**
	 * 获取：采购编号
	 */
	public String getCaigoubianhao() {
		return caigoubianhao;
	}
	/**
	 * 设置：商品编号
	 */
	public void setShangpinbianhao(String shangpinbianhao) {
		this.shangpinbianhao = shangpinbianhao;
	}
	/**
	 * 获取：商品编号
	 */
	public String getShangpinbianhao() {
		return shangpinbianhao;
	}
	/**
	 * 设置：商品名称
	 */
	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}
	/**
	 * 获取：商品名称
	 */
	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：采购价格
	 */
	public void setCaigoujiage(Integer caigoujiage) {
		this.caigoujiage = caigoujiage;
	}
	/**
	 * 获取：采购价格
	 */
	public Integer getCaigoujiage() {
		return caigoujiage;
	}
	/**
	 * 设置：退货金额
	 */
	public void setTuihuojine(Integer tuihuojine) {
		this.tuihuojine = tuihuojine;
	}
	/**
	 * 获取：退货金额
	 */
	public Integer getTuihuojine() {
		return tuihuojine;
	}
	/**
	 * 设置：退货原因
	 */
	public void setTuihuoyuanyin(String tuihuoyuanyin) {
		this.tuihuoyuanyin = tuihuoyuanyin;
	}
	/**
	 * 获取：退货原因
	 */
	public String getTuihuoyuanyin() {
		return tuihuoyuanyin;
	}
	/**
	 * 设置：退货日期
	 */
	public void setTuihuoriqi(Date tuihuoriqi) {
		this.tuihuoriqi = tuihuoriqi;
	}
	/**
	 * 获取：退货日期
	 */
	public Date getTuihuoriqi() {
		return tuihuoriqi;
	}
	/**
	 * 设置：员工工号
	 */
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
	/**
	 * 设置：员工姓名
	 */
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}

}
