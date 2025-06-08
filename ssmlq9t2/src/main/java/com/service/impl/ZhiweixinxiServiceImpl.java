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


import com.dao.ZhiweixinxiDao;
import com.entity.ZhiweixinxiEntity;
import com.service.ZhiweixinxiService;
import com.entity.vo.ZhiweixinxiVO;
import com.entity.view.ZhiweixinxiView;

@Service("zhiweixinxiService")
public class ZhiweixinxiServiceImpl extends ServiceImpl<ZhiweixinxiDao, ZhiweixinxiEntity> implements ZhiweixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiweixinxiEntity> page = this.selectPage(
                new Query<ZhiweixinxiEntity>(params).getPage(),
                new EntityWrapper<ZhiweixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiweixinxiEntity> wrapper) {
		  Page<ZhiweixinxiView> page =new Query<ZhiweixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhiweixinxiVO> selectListVO(Wrapper<ZhiweixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiweixinxiVO selectVO(Wrapper<ZhiweixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiweixinxiView> selectListView(Wrapper<ZhiweixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiweixinxiView selectView(Wrapper<ZhiweixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
