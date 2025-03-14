package com.entity.view;

import com.entity.DiscusstongzhigonggaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 通知公告评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-11 20:44:58
 */
@TableName("discusstongzhigonggao")
public class DiscusstongzhigonggaoView  extends DiscusstongzhigonggaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusstongzhigonggaoView(){
	}
 
 	public DiscusstongzhigonggaoView(DiscusstongzhigonggaoEntity discusstongzhigonggaoEntity){
 	try {
			BeanUtils.copyProperties(this, discusstongzhigonggaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
