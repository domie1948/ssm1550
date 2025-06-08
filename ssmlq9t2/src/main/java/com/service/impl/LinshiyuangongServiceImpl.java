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


import com.dao.LinshiyuangongDao;
import com.entity.LinshiyuangongEntity;
import com.service.LinshiyuangongService;
import com.entity.vo.LinshiyuangongVO;
import com.entity.view.LinshiyuangongView;

@Service("linshiyuangongService")
public class LinshiyuangongServiceImpl extends ServiceImpl<LinshiyuangongDao, LinshiyuangongEntity> implements LinshiyuangongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LinshiyuangongEntity> page = this.selectPage(
                new Query<LinshiyuangongEntity>(params).getPage(),
                new EntityWrapper<LinshiyuangongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LinshiyuangongEntity> wrapper) {
		  Page<LinshiyuangongView> page =new Query<LinshiyuangongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LinshiyuangongVO> selectListVO(Wrapper<LinshiyuangongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LinshiyuangongVO selectVO(Wrapper<LinshiyuangongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LinshiyuangongView> selectListView(Wrapper<LinshiyuangongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LinshiyuangongView selectView(Wrapper<LinshiyuangongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
