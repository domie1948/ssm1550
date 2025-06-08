package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhengshiyuangongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhengshiyuangongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengshiyuangongView;


/**
 * 正式员工
 *
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface ZhengshiyuangongService extends IService<ZhengshiyuangongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhengshiyuangongVO> selectListVO(Wrapper<ZhengshiyuangongEntity> wrapper);
   	
   	ZhengshiyuangongVO selectVO(@Param("ew") Wrapper<ZhengshiyuangongEntity> wrapper);
   	
   	List<ZhengshiyuangongView> selectListView(Wrapper<ZhengshiyuangongEntity> wrapper);
   	
   	ZhengshiyuangongView selectView(@Param("ew") Wrapper<ZhengshiyuangongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhengshiyuangongEntity> wrapper);
   	
}

