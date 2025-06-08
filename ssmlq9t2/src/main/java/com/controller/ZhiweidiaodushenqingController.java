package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhiweidiaodushenqingEntity;
import com.entity.view.ZhiweidiaodushenqingView;

import com.service.ZhiweidiaodushenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 职位调度申请
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
@RestController
@RequestMapping("/zhiweidiaodushenqing")
public class ZhiweidiaodushenqingController {
    @Autowired
    private ZhiweidiaodushenqingService zhiweidiaodushenqingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiweidiaodushenqingEntity zhiweidiaodushenqing, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		zhiweidiaodushenqing.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

        EntityWrapper<ZhiweidiaodushenqingEntity> ew = new EntityWrapper<ZhiweidiaodushenqingEntity>();
		PageUtils page = zhiweidiaodushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiweidiaodushenqing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiweidiaodushenqingEntity zhiweidiaodushenqing, HttpServletRequest request){
        EntityWrapper<ZhiweidiaodushenqingEntity> ew = new EntityWrapper<ZhiweidiaodushenqingEntity>();
		PageUtils page = zhiweidiaodushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiweidiaodushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiweidiaodushenqingEntity zhiweidiaodushenqing){
       	EntityWrapper<ZhiweidiaodushenqingEntity> ew = new EntityWrapper<ZhiweidiaodushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiweidiaodushenqing, "zhiweidiaodushenqing")); 
        return R.ok().put("data", zhiweidiaodushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiweidiaodushenqingEntity zhiweidiaodushenqing){
        EntityWrapper< ZhiweidiaodushenqingEntity> ew = new EntityWrapper< ZhiweidiaodushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiweidiaodushenqing, "zhiweidiaodushenqing")); 
		ZhiweidiaodushenqingView zhiweidiaodushenqingView =  zhiweidiaodushenqingService.selectView(ew);
		return R.ok("查询职位调度申请成功").put("data", zhiweidiaodushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiweidiaodushenqingEntity zhiweidiaodushenqing = zhiweidiaodushenqingService.selectById(id);
        return R.ok().put("data", zhiweidiaodushenqing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiweidiaodushenqingEntity zhiweidiaodushenqing = zhiweidiaodushenqingService.selectById(id);
        return R.ok().put("data", zhiweidiaodushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiweidiaodushenqingEntity zhiweidiaodushenqing, HttpServletRequest request){
    	zhiweidiaodushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiweidiaodushenqing);
    	zhiweidiaodushenqing.setUserid((Long)request.getSession().getAttribute("userId"));

        zhiweidiaodushenqingService.insert(zhiweidiaodushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ZhiweidiaodushenqingEntity zhiweidiaodushenqing, HttpServletRequest request){
    	zhiweidiaodushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiweidiaodushenqing);

        zhiweidiaodushenqingService.insert(zhiweidiaodushenqing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiweidiaodushenqingEntity zhiweidiaodushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiweidiaodushenqing);
        zhiweidiaodushenqingService.updateById(zhiweidiaodushenqing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiweidiaodushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZhiweidiaodushenqingEntity> wrapper = new EntityWrapper<ZhiweidiaodushenqingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = zhiweidiaodushenqingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
