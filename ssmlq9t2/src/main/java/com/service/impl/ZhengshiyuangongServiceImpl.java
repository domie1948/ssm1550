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


import com.dao.ZhengshiyuangongDao;
import com.entity.ZhengshiyuangongEntity;
import com.service.ZhengshiyuangongService;
import com.entity.vo.ZhengshiyuangongVO;
import com.entity.view.ZhengshiyuangongView;

@Service("zhengshiyuangongService")
public class ZhengshiyuangongServiceImpl extends ServiceImpl<ZhengshiyuangongDao, ZhengshiyuangongEntity> implements ZhengshiyuangongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhengshiyuangongEntity> page = this.selectPage(
                new Query<ZhengshiyuangongEntity>(params).getPage(),
                new EntityWrapper<ZhengshiyuangongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhengshiyuangongEntity> wrapper) {
		  Page<ZhengshiyuangongView> page =new Query<ZhengshiyuangongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhengshiyuangongVO> selectListVO(Wrapper<ZhengshiyuangongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhengshiyuangongVO selectVO(Wrapper<ZhengshiyuangongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhengshiyuangongView> selectListView(Wrapper<ZhengshiyuangongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhengshiyuangongView selectView(Wrapper<ZhengshiyuangongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
