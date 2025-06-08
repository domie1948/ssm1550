package com.dao;

import com.entity.LinshiyuangongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LinshiyuangongVO;
import com.entity.view.LinshiyuangongView;


/**
 * 临时员工
 * 
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface LinshiyuangongDao extends BaseMapper<LinshiyuangongEntity> {
	
	List<LinshiyuangongVO> selectListVO(@Param("ew") Wrapper<LinshiyuangongEntity> wrapper);
	
	LinshiyuangongVO selectVO(@Param("ew") Wrapper<LinshiyuangongEntity> wrapper);
	
	List<LinshiyuangongView> selectListView(@Param("ew") Wrapper<LinshiyuangongEntity> wrapper);

	List<LinshiyuangongView> selectListView(Pagination page,@Param("ew") Wrapper<LinshiyuangongEntity> wrapper);
	
	LinshiyuangongView selectView(@Param("ew") Wrapper<LinshiyuangongEntity> wrapper);
	
}
