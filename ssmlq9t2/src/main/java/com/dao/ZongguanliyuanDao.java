package com.dao;

import com.entity.ZongguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZongguanliyuanVO;
import com.entity.view.ZongguanliyuanView;


/**
 * 总管理员
 * 
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface ZongguanliyuanDao extends BaseMapper<ZongguanliyuanEntity> {
	
	List<ZongguanliyuanVO> selectListVO(@Param("ew") Wrapper<ZongguanliyuanEntity> wrapper);
	
	ZongguanliyuanVO selectVO(@Param("ew") Wrapper<ZongguanliyuanEntity> wrapper);
	
	List<ZongguanliyuanView> selectListView(@Param("ew") Wrapper<ZongguanliyuanEntity> wrapper);

	List<ZongguanliyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ZongguanliyuanEntity> wrapper);
	
	ZongguanliyuanView selectView(@Param("ew") Wrapper<ZongguanliyuanEntity> wrapper);
	
}
