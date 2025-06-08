package com.dao;

import com.entity.ZhengshiyuangongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhengshiyuangongVO;
import com.entity.view.ZhengshiyuangongView;


/**
 * 正式员工
 * 
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface ZhengshiyuangongDao extends BaseMapper<ZhengshiyuangongEntity> {
	
	List<ZhengshiyuangongVO> selectListVO(@Param("ew") Wrapper<ZhengshiyuangongEntity> wrapper);
	
	ZhengshiyuangongVO selectVO(@Param("ew") Wrapper<ZhengshiyuangongEntity> wrapper);
	
	List<ZhengshiyuangongView> selectListView(@Param("ew") Wrapper<ZhengshiyuangongEntity> wrapper);

	List<ZhengshiyuangongView> selectListView(Pagination page,@Param("ew") Wrapper<ZhengshiyuangongEntity> wrapper);
	
	ZhengshiyuangongView selectView(@Param("ew") Wrapper<ZhengshiyuangongEntity> wrapper);
	
}
