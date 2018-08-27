package cn.kepu.elearning.dao;

import java.util.List;

import cn.kepu.elearning.pojo.Activity;

public interface IActivityDao {
	
	void istAct(Activity activity);
	
	List<Activity> selAllActs();
}
