package cn.kepu.elearning.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cn.kepu.elearning.pojo.EmergencyPlan;
import cn.kepu.elearning.pojo.Location;
import cn.kepu.elearning.pojo.Route;

public interface IRouteMapService {
	
	List<Route> checkRoutesInPlan(Integer planID, Integer zmLev);
	
	void savePoi(Location location);
	
	
	List<EmergencyPlan> chkSegs(Location location);
	
	List<List<Location>> driveWaysInPlan(Integer planID, Location firePoint);
	
	List<List<Location>> pathsInPlan(Integer planID, Location firePoint);
	
	List<List<Location>> poiInPlan(Integer planID, Location firePoint);
	
	Location repositionFP(Location firePoint);
	
	List<EmergencyPlan> srchPlanSkch(List<EmergencyPlan> emergencyPlans);
	
	JSONObject srchPlanDet(Integer planID);
		
}
