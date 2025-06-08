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


import com.dao.ZhiweidiaodushenqingDao;
import com.entity.ZhiweidiaodushenqingEntity;
import com.service.ZhiweidiaodushenqingService;
import com.entity.vo.ZhiweidiaodushenqingVO;
import com.entity.view.ZhiweidiaodushenqingView;

@Service("zhiweidiaodushenqingService")
public class ZhiweidiaodushenqingServiceImpl extends ServiceImpl<ZhiweidiaodushenqingDao, ZhiweidiaodushenqingEntity> implements ZhiweidiaodushenqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiweidiaodushenqingEntity> page = this.selectPage(
                new Query<ZhiweidiaodushenqingEntity>(params).getPage(),
                new EntityWrapper<ZhiweidiaodushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiweidiaodushenqingEntity> wrapper) {
		  Page<ZhiweidiaodushenqingView> page =new Query<ZhiweidiaodushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhiweidiaodushenqingVO> selectListVO(Wrapper<ZhiweidiaodushenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiweidiaodushenqingVO selectVO(Wrapper<ZhiweidiaodushenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiweidiaodushenqingView> selectListView(Wrapper<ZhiweidiaodushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiweidiaodushenqingView selectView(Wrapper<ZhiweidiaodushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
