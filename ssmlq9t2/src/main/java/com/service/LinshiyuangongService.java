package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LinshiyuangongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LinshiyuangongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LinshiyuangongView;


/**
 * 临时员工
 *
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface LinshiyuangongService extends IService<LinshiyuangongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LinshiyuangongVO> selectListVO(Wrapper<LinshiyuangongEntity> wrapper);
   	
   	LinshiyuangongVO selectVO(@Param("ew") Wrapper<LinshiyuangongEntity> wrapper);
   	
   	List<LinshiyuangongView> selectListView(Wrapper<LinshiyuangongEntity> wrapper);
   	
   	LinshiyuangongView selectView(@Param("ew") Wrapper<LinshiyuangongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LinshiyuangongEntity> wrapper);
   	
}

