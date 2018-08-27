package cn.kepu.elearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.kepu.elearning.dao.IMoniterVideoDao;
import cn.kepu.elearning.service.IStatisticService;

@Service("statisticService")
public class StatisticServiceImpl implements IStatisticService{

	@Autowired
	IMoniterVideoDao moniterVideoDao;
	
	public int[] chkStorage(){
		int[] res = new int[4];
		
		res[1] = moniterVideoDao.selMvideoCount() * 150;
		res[2] = moniterVideoDao.selRvideoCount() * 150;
		res[3] = moniterVideoDao.selAvideoCount() * 150;
		res[0] = 1024 * 10 - (res[1] + res[2] + res[3]);
				
		return res;
	}
	
	
}
