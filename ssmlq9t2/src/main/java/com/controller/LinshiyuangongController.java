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

import com.entity.LinshiyuangongEntity;
import com.entity.view.LinshiyuangongView;

import com.service.LinshiyuangongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 临时员工
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-18 19:38:53
 */
@RestController
@RequestMapping("/linshiyuangong")
public class LinshiyuangongController {
    @Autowired
    private LinshiyuangongService linshiyuangongService;
    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		LinshiyuangongEntity user = linshiyuangongService.selectOne(new EntityWrapper<LinshiyuangongEntity>().eq("gonghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"linshiyuangong",  "临时员工" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody LinshiyuangongEntity linshiyuangong){
    	//ValidatorUtils.validateEntity(linshiyuangong);
    	LinshiyuangongEntity user = linshiyuangongService.selectOne(new EntityWrapper<LinshiyuangongEntity>().eq("gonghao", linshiyuangong.getGonghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		linshiyuangong.setId(uId);
        linshiyuangongService.insert(linshiyuangong);
        return R.ok();
    }
	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        LinshiyuangongEntity user = linshiyuangongService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	LinshiyuangongEntity user = linshiyuangongService.selectOne(new EntityWrapper<LinshiyuangongEntity>().eq("gonghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        linshiyuangongService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LinshiyuangongEntity linshiyuangong, 
		HttpServletRequest request){

        EntityWrapper<LinshiyuangongEntity> ew = new EntityWrapper<LinshiyuangongEntity>();
		PageUtils page = linshiyuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, linshiyuangong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LinshiyuangongEntity linshiyuangong, HttpServletRequest request){
        EntityWrapper<LinshiyuangongEntity> ew = new EntityWrapper<LinshiyuangongEntity>();
		PageUtils page = linshiyuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, linshiyuangong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LinshiyuangongEntity linshiyuangong){
       	EntityWrapper<LinshiyuangongEntity> ew = new EntityWrapper<LinshiyuangongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( linshiyuangong, "linshiyuangong")); 
        return R.ok().put("data", linshiyuangongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LinshiyuangongEntity linshiyuangong){
        EntityWrapper< LinshiyuangongEntity> ew = new EntityWrapper< LinshiyuangongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( linshiyuangong, "linshiyuangong")); 
		LinshiyuangongView linshiyuangongView =  linshiyuangongService.selectView(ew);
		return R.ok("查询临时员工成功").put("data", linshiyuangongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LinshiyuangongEntity linshiyuangong = linshiyuangongService.selectById(id);
        return R.ok().put("data", linshiyuangong);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LinshiyuangongEntity linshiyuangong = linshiyuangongService.selectById(id);
        return R.ok().put("data", linshiyuangong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LinshiyuangongEntity linshiyuangong, HttpServletRequest request){
    	linshiyuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(linshiyuangong);
    	LinshiyuangongEntity user = linshiyuangongService.selectOne(new EntityWrapper<LinshiyuangongEntity>().eq("gonghao", linshiyuangong.getGonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		linshiyuangong.setId(new Date().getTime());
        linshiyuangongService.insert(linshiyuangong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LinshiyuangongEntity linshiyuangong, HttpServletRequest request){
    	linshiyuangong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(linshiyuangong);
    	LinshiyuangongEntity user = linshiyuangongService.selectOne(new EntityWrapper<LinshiyuangongEntity>().eq("gonghao", linshiyuangong.getGonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		linshiyuangong.setId(new Date().getTime());
        linshiyuangongService.insert(linshiyuangong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LinshiyuangongEntity linshiyuangong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(linshiyuangong);
        linshiyuangongService.updateById(linshiyuangong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        linshiyuangongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LinshiyuangongEntity> wrapper = new EntityWrapper<LinshiyuangongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = linshiyuangongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
