package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GongzuojinduDao;
import com.entity.GongzuojinduEntity;
import com.service.GongzuojinduService;
import com.entity.vo.GongzuojinduVO;
import com.entity.view.GongzuojinduView;

@Service("gongzuojinduService")
public class GongzuojinduServiceImpl extends ServiceImpl<GongzuojinduDao, GongzuojinduEntity> implements GongzuojinduService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuojinduEntity> page = this.selectPage(
                new Query<GongzuojinduEntity>(params).getPage(),
                new EntityWrapper<GongzuojinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuojinduEntity> wrapper) {
		  Page<GongzuojinduView> page =new Query<GongzuojinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongzuojinduVO> selectListVO(Wrapper<GongzuojinduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongzuojinduVO selectVO(Wrapper<GongzuojinduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongzuojinduView> selectListView(Wrapper<GongzuojinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuojinduView selectView(Wrapper<GongzuojinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
