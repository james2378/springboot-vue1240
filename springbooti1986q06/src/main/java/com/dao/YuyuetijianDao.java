package com.dao;

import com.entity.YuyuetijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyuetijianVO;
import com.entity.view.YuyuetijianView;


/**
 * 预约体检
 * 
 * @author 
 * @email 
 * @date 2024-03-11 20:44:57
 */
public interface YuyuetijianDao extends BaseMapper<YuyuetijianEntity> {
	
	List<YuyuetijianVO> selectListVO(@Param("ew") Wrapper<YuyuetijianEntity> wrapper);
	
	YuyuetijianVO selectVO(@Param("ew") Wrapper<YuyuetijianEntity> wrapper);
	
	List<YuyuetijianView> selectListView(@Param("ew") Wrapper<YuyuetijianEntity> wrapper);

	List<YuyuetijianView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuetijianEntity> wrapper);

	
	YuyuetijianView selectView(@Param("ew") Wrapper<YuyuetijianEntity> wrapper);
	

}
