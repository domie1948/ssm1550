package com.dao;

import com.entity.ShujukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShujukuVO;
import com.entity.view.ShujukuView;


/**
 * 数据库
 * 
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface ShujukuDao extends BaseMapper<ShujukuEntity> {
	
	List<ShujukuVO> selectListVO(@Param("ew") Wrapper<ShujukuEntity> wrapper);
	
	ShujukuVO selectVO(@Param("ew") Wrapper<ShujukuEntity> wrapper);
	
	List<ShujukuView> selectListView(@Param("ew") Wrapper<ShujukuEntity> wrapper);

	List<ShujukuView> selectListView(Pagination page,@Param("ew") Wrapper<ShujukuEntity> wrapper);
	
	ShujukuView selectView(@Param("ew") Wrapper<ShujukuEntity> wrapper);
	
}
