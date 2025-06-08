package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZongguanliyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZongguanliyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZongguanliyuanView;


/**
 * 总管理员
 *
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface ZongguanliyuanService extends IService<ZongguanliyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZongguanliyuanVO> selectListVO(Wrapper<ZongguanliyuanEntity> wrapper);
   	
   	ZongguanliyuanVO selectVO(@Param("ew") Wrapper<ZongguanliyuanEntity> wrapper);
   	
   	List<ZongguanliyuanView> selectListView(Wrapper<ZongguanliyuanEntity> wrapper);
   	
   	ZongguanliyuanView selectView(@Param("ew") Wrapper<ZongguanliyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZongguanliyuanEntity> wrapper);
   	
}

