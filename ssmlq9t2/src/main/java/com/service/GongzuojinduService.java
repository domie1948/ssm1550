package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzuojinduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongzuojinduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuojinduView;


/**
 * 工作进度
 *
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface GongzuojinduService extends IService<GongzuojinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuojinduVO> selectListVO(Wrapper<GongzuojinduEntity> wrapper);
   	
   	GongzuojinduVO selectVO(@Param("ew") Wrapper<GongzuojinduEntity> wrapper);
   	
   	List<GongzuojinduView> selectListView(Wrapper<GongzuojinduEntity> wrapper);
   	
   	GongzuojinduView selectView(@Param("ew") Wrapper<GongzuojinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuojinduEntity> wrapper);
   	
}

