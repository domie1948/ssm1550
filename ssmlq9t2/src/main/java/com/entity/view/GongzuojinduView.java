package com.entity.view;

import com.entity.GongzuojinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 工作进度
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
@TableName("gongzuojindu")
public class GongzuojinduView  extends GongzuojinduEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzuojinduView(){
	}
 
 	public GongzuojinduView(GongzuojinduEntity gongzuojinduEntity){
 	try {
			BeanUtils.copyProperties(this, gongzuojinduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
