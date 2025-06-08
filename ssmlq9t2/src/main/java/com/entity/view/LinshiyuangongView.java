package com.entity.view;

import com.entity.LinshiyuangongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 临时员工
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
@TableName("linshiyuangong")
public class LinshiyuangongView  extends LinshiyuangongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LinshiyuangongView(){
	}
 
 	public LinshiyuangongView(LinshiyuangongEntity linshiyuangongEntity){
 	try {
			BeanUtils.copyProperties(this, linshiyuangongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
