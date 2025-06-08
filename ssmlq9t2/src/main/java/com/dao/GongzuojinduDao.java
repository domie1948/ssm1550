package com.dao;

import com.entity.GongzuojinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzuojinduVO;
import com.entity.view.GongzuojinduView;


/**
 * 工作进度
 * 
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface GongzuojinduDao extends BaseMapper<GongzuojinduEntity> {
	
	List<GongzuojinduVO> selectListVO(@Param("ew") Wrapper<GongzuojinduEntity> wrapper);
	
	GongzuojinduVO selectVO(@Param("ew") Wrapper<GongzuojinduEntity> wrapper);
	
	List<GongzuojinduView> selectListView(@Param("ew") Wrapper<GongzuojinduEntity> wrapper);

	List<GongzuojinduView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuojinduEntity> wrapper);
	
	GongzuojinduView selectView(@Param("ew") Wrapper<GongzuojinduEntity> wrapper);
	
}
