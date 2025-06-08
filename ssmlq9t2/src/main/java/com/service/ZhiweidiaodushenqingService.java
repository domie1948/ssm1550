package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiweidiaodushenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiweidiaodushenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiweidiaodushenqingView;


/**
 * 职位调度申请
 *
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface ZhiweidiaodushenqingService extends IService<ZhiweidiaodushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiweidiaodushenqingVO> selectListVO(Wrapper<ZhiweidiaodushenqingEntity> wrapper);
   	
   	ZhiweidiaodushenqingVO selectVO(@Param("ew") Wrapper<ZhiweidiaodushenqingEntity> wrapper);
   	
   	List<ZhiweidiaodushenqingView> selectListView(Wrapper<ZhiweidiaodushenqingEntity> wrapper);
   	
   	ZhiweidiaodushenqingView selectView(@Param("ew") Wrapper<ZhiweidiaodushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiweidiaodushenqingEntity> wrapper);
   	
}

