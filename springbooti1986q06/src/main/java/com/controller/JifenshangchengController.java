package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JifenshangchengEntity;
import com.entity.view.JifenshangchengView;

import com.service.JifenshangchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 积分商城
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 20:44:58
 */
@RestController
@RequestMapping("/jifenshangcheng")
public class JifenshangchengController {
    @Autowired
    private JifenshangchengService jifenshangchengService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JifenshangchengEntity jifenshangcheng,
		HttpServletRequest request){
        EntityWrapper<JifenshangchengEntity> ew = new EntityWrapper<JifenshangchengEntity>();

		PageUtils page = jifenshangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenshangcheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JifenshangchengEntity jifenshangcheng, 
		HttpServletRequest request){
        EntityWrapper<JifenshangchengEntity> ew = new EntityWrapper<JifenshangchengEntity>();

		PageUtils page = jifenshangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenshangcheng), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JifenshangchengEntity jifenshangcheng){
       	EntityWrapper<JifenshangchengEntity> ew = new EntityWrapper<JifenshangchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jifenshangcheng, "jifenshangcheng")); 
        return R.ok().put("data", jifenshangchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JifenshangchengEntity jifenshangcheng){
        EntityWrapper< JifenshangchengEntity> ew = new EntityWrapper< JifenshangchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jifenshangcheng, "jifenshangcheng")); 
		JifenshangchengView jifenshangchengView =  jifenshangchengService.selectView(ew);
		return R.ok("查询积分商城成功").put("data", jifenshangchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JifenshangchengEntity jifenshangcheng = jifenshangchengService.selectById(id);
        return R.ok().put("data", jifenshangcheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JifenshangchengEntity jifenshangcheng = jifenshangchengService.selectById(id);
        return R.ok().put("data", jifenshangcheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JifenshangchengEntity jifenshangcheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jifenshangcheng);
        jifenshangchengService.insert(jifenshangcheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JifenshangchengEntity jifenshangcheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jifenshangcheng);
        jifenshangchengService.insert(jifenshangcheng);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JifenshangchengEntity jifenshangcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenshangcheng);
        jifenshangchengService.updateById(jifenshangcheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jifenshangchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
