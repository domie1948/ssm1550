package com.dao;

import com.entity.ZhiweidiaodushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiweidiaodushenqingVO;
import com.entity.view.ZhiweidiaodushenqingView;


/**
 * 职位调度申请
 * 
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
public interface ZhiweidiaodushenqingDao extends BaseMapper<ZhiweidiaodushenqingEntity> {
	
	List<ZhiweidiaodushenqingVO> selectListVO(@Param("ew") Wrapper<ZhiweidiaodushenqingEntity> wrapper);
	
	ZhiweidiaodushenqingVO selectVO(@Param("ew") Wrapper<ZhiweidiaodushenqingEntity> wrapper);
	
	List<ZhiweidiaodushenqingView> selectListView(@Param("ew") Wrapper<ZhiweidiaodushenqingEntity> wrapper);

	List<ZhiweidiaodushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiweidiaodushenqingEntity> wrapper);
	
	ZhiweidiaodushenqingView selectView(@Param("ew") Wrapper<ZhiweidiaodushenqingEntity> wrapper);
	
}
