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


import com.dao.ZongguanliyuanDao;
import com.entity.ZongguanliyuanEntity;
import com.service.ZongguanliyuanService;
import com.entity.vo.ZongguanliyuanVO;
import com.entity.view.ZongguanliyuanView;

@Service("zongguanliyuanService")
public class ZongguanliyuanServiceImpl extends ServiceImpl<ZongguanliyuanDao, ZongguanliyuanEntity> implements ZongguanliyuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZongguanliyuanEntity> page = this.selectPage(
                new Query<ZongguanliyuanEntity>(params).getPage(),
                new EntityWrapper<ZongguanliyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZongguanliyuanEntity> wrapper) {
		  Page<ZongguanliyuanView> page =new Query<ZongguanliyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZongguanliyuanVO> selectListVO(Wrapper<ZongguanliyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZongguanliyuanVO selectVO(Wrapper<ZongguanliyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZongguanliyuanView> selectListView(Wrapper<ZongguanliyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZongguanliyuanView selectView(Wrapper<ZongguanliyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
