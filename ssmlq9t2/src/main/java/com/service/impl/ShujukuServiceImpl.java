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


import com.dao.ShujukuDao;
import com.entity.ShujukuEntity;
import com.service.ShujukuService;
import com.entity.vo.ShujukuVO;
import com.entity.view.ShujukuView;

@Service("shujukuService")
public class ShujukuServiceImpl extends ServiceImpl<ShujukuDao, ShujukuEntity> implements ShujukuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShujukuEntity> page = this.selectPage(
                new Query<ShujukuEntity>(params).getPage(),
                new EntityWrapper<ShujukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShujukuEntity> wrapper) {
		  Page<ShujukuView> page =new Query<ShujukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShujukuVO> selectListVO(Wrapper<ShujukuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShujukuVO selectVO(Wrapper<ShujukuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShujukuView> selectListView(Wrapper<ShujukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShujukuView selectView(Wrapper<ShujukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
