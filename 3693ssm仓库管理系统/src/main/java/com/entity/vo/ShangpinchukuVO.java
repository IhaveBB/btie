package com.entity.vo;

import com.entity.ShangpinchukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 商品出库
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-04-02 11:00:00
 */
public class ShangpinchukuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品编号
	 */
	
	private String shangpinbianhao;
		
	/**
	 * 商品分类
	 */
	
	private String shangpinfenlei;
		
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
	 * 售价
	 */
	
	private Integer shoujia;
		
	/**
	 * 总金额
	 */
	
	private Integer zongjine;
		
	/**
	 * 出库类型
	 */
	
	private String chukuleixing;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
				
	
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
	 * 设置：商品分类
	 */
	 
	public void setShangpinfenlei(String shangpinfenlei) {
		this.shangpinfenlei = shangpinfenlei;
	}
	
	/**
	 * 获取：商品分类
	 */
	public String getShangpinfenlei() {
		return shangpinfenlei;
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
	 * 设置：售价
	 */
	 
	public void setShoujia(Integer shoujia) {
		this.shoujia = shoujia;
	}
	
	/**
	 * 获取：售价
	 */
	public Integer getShoujia() {
		return shoujia;
	}
				
	
	/**
	 * 设置：总金额
	 */
	 
	public void setZongjine(Integer zongjine) {
		this.zongjine = zongjine;
	}
	
	/**
	 * 获取：总金额
	 */
	public Integer getZongjine() {
		return zongjine;
	}
				
	
	/**
	 * 设置：出库类型
	 */
	 
	public void setChukuleixing(String chukuleixing) {
		this.chukuleixing = chukuleixing;
	}
	
	/**
	 * 获取：出库类型
	 */
	public String getChukuleixing() {
		return chukuleixing;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
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
