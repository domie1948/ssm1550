package com.entity.vo;

import com.entity.ShujukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 数据库
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public class ShujukuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 权限
	 */
	
	private String quanxian;
				
	
	/**
	 * 设置：权限
	 */
	 
	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}
	
	/**
	 * 获取：权限
	 */
	public String getQuanxian() {
		return quanxian;
	}
			
}
