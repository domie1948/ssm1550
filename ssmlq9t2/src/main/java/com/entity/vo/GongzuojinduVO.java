package com.entity.vo;

import com.entity.GongzuojinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 工作进度
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public class GongzuojinduVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 职位
	 */
	
	private String zhiwei;
		
	/**
	 * 工作
	 */
	
	private String gongzuo;
		
	/**
	 * 起始时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date qishishijian;
		
	/**
	 * 结束时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jieshushijian;
		
	/**
	 * 当前进度
	 */
	
	private String dangqianjindu;
				
	
	/**
	 * 设置：职位
	 */
	 
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	
	/**
	 * 获取：职位
	 */
	public String getZhiwei() {
		return zhiwei;
	}
				
	
	/**
	 * 设置：工作
	 */
	 
	public void setGongzuo(String gongzuo) {
		this.gongzuo = gongzuo;
	}
	
	/**
	 * 获取：工作
	 */
	public String getGongzuo() {
		return gongzuo;
	}
				
	
	/**
	 * 设置：起始时间
	 */
	 
	public void setQishishijian(Date qishishijian) {
		this.qishishijian = qishishijian;
	}
	
	/**
	 * 获取：起始时间
	 */
	public Date getQishishijian() {
		return qishishijian;
	}
				
	
	/**
	 * 设置：结束时间
	 */
	 
	public void setJieshushijian(Date jieshushijian) {
		this.jieshushijian = jieshushijian;
	}
	
	/**
	 * 获取：结束时间
	 */
	public Date getJieshushijian() {
		return jieshushijian;
	}
				
	
	/**
	 * 设置：当前进度
	 */
	 
	public void setDangqianjindu(String dangqianjindu) {
		this.dangqianjindu = dangqianjindu;
	}
	
	/**
	 * 获取：当前进度
	 */
	public String getDangqianjindu() {
		return dangqianjindu;
	}
			
}
