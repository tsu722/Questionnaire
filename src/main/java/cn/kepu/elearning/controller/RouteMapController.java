package cn.kepu.elearning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.kepu.elearning.pojo.EmergencyPlan;
import cn.kepu.elearning.pojo.Location;
import cn.kepu.elearning.pojo.Route;
import cn.kepu.elearning.service.IRouteMapService;

@Controller
@RequestMapping("/map")
public class RouteMapController {
	
	
	@Autowired
	@Qualifier("routemapService")
	private IRouteMapService routemapService;
	

	//测试ARCGIS JS API
	@RequestMapping("/getMap")
	public String getMap(){
		return "MapPages/testMap";
	}
	
	//测试百度地图API
	@RequestMapping("/showMap")
	public String showMap(){
		return "MapPages/showMap";
	}
	
	//测试DIY+Canvas
	@RequestMapping("/mapView")
	public String mapView(){
		return "MapPages/mapNavigator";
	}
	
	@RequestMapping("/miniMap")
	public String miniMap(){
		return "MapPages/miniMap";
	}
	
	//测试多张图片一起加载
	@RequestMapping("/tileTrial")
	public String tileTrial(){
		return "MapPages/tileTrial";
	}
	
	/**
	 * 根据前台传来的地图级数和方案编号加载路径（后续将添加上其他POI）
	 * @param reqLoc
	 * @return
	 */
	@RequestMapping("/getRoute")
	@ResponseBody
	public JSONObject getRoute(@RequestBody Location reqLoc){		//这里以点作为参数逻辑上没有什么意义，只是前台数据要和后台bean对应，而location对象正好有这两个属性
		JSONObject result = new JSONObject();
		List<Location> driveWay = new ArrayList<Location>(); //最终返回给前端公路和小路两个点集
		List<Location> path = new ArrayList<Location>();

//		Route route = routemapService.checkSinRoute(reqLoc.getRtID(), reqLoc.getZmLev());	
//		result.put("points", route.getPoints());
		
		List<Route> routes = routemapService.checkRoutesInPlan(reqLoc.getZmLev(), reqLoc.getRtID());  //有点容易误会，这里传入的是放缩级别和方案ID，不是路径ID
		for(Route route : routes){
			if (route.getRtType() == 1) {
				driveWay.addAll(route.getPoints());
			} else {
				path.addAll(route.getPoints());
			}
		}
		result.put("driveWay", driveWay);
		result.put("path", path);
		return result;
	}
	
	/**
	 * 查看预案详情
	 * @return
	 */
	@RequestMapping("/planInfo")
	public String planInfo(){
		return "PlanPages/planInfo";
	}
	
	/**
	 * 跳转至像素坐标拾取页面（临时小工具：坐标拾取存储器）
	 * @return
	 */
	@RequestMapping("/locGetter")
	public String locGetter(){
		return "MapPages/pointGetter";
	}
	
	/**
	 * 接收前台传来的位置（临时小工具：坐标拾取存储器）
	 * @param location
	 * @return
	 */
	@RequestMapping("/sendLoc")
	@ResponseBody
	public JSONObject sendLoc(@RequestBody Location location){
		JSONObject result = new JSONObject();
		routemapService.savePoi(location);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 测试路线的分段情况，后续需改写成根据火点位置获取预案
	 * Controller中的内容：
	 * 1、入参将改成只有火点位置   ---根据火点位置判断预案的ID  一个函数
	 * 2、根据预案ID加载预案中的所有内容   ---另一个函数
	 * @param location
	 * @return
	 */
	@RequestMapping("/testSegment")
	@ResponseBody
	public JSONObject testSegment(@RequestBody Location location){
		JSONObject result = new JSONObject();
		List<List<Location>> poisInPlan = new ArrayList<List<Location>>();
		int scorePlanID;     //被最终选定的预案ID
		
		if (location.getZmLev() > 1) {										//放大地图重定位火点
			location = routemapService.repositionFP(location);
		}
		
		if (location.getZmLev() > 1 && location.getRtID() != -1) {			//这里rtID代表的是预案ID，只是为了和location对象的能绑定所以没改名
			scorePlanID = location.getRtID();								//放缩级别大于1且预案ID有效，那么不再计算，直接加载预案			
		} else if (location.getZmLev() == 1 && location.getRtID() != -1) {	//放缩级别为1但是预案ID有效，用于切换预案和缩小到1级地图
			scorePlanID = location.getRtID();
		} else{																		//原始获得预案，参数为(1,-1)，这里获得两个值，一个预案的rank，然后rank排名1的加载具体预案信息		
			List<EmergencyPlan> candPlans = routemapService.chkSegs(location);
			scorePlanID = candPlans.get(candPlans.size()-1).getPlanID();			//最终要改成选第一个，这里只是想加载只有一条路的预案
			result.put("availablePlans", candPlans);
		}
		
		List<List<Location>> driveWay = routemapService.driveWaysInPlan(scorePlanID, location);
		List<List<Location>> path = routemapService.pathsInPlan(scorePlanID, location);
		poisInPlan = routemapService.poiInPlan(scorePlanID,location);
				
		if (poisInPlan.size() < 3) {		//物资点、人员驻扎点、水源点是否齐全
			result.put("msg", 0);
			return result;
		}
		
		result.put("driveWay", driveWay);
		result.put("path", path);
		result.put("materials", poisInPlan.get(0));
		result.put("watersource", poisInPlan.get(1));
		result.put("crewStays", poisInPlan.get(2));
		result.put("scorePlanID", scorePlanID);
		result.put("msg", 1);
		return result;
	}
	
	
	/**
	 * 火点重定位（用于放缩）
	 * @param location
	 * @return
	 */
	@RequestMapping("/repositionFP")
	@ResponseBody
	public JSONObject repositionFP(@RequestBody Location location){
		JSONObject result = new JSONObject();
		if (location.getZmLev() > 1) {										//放大地图重定位火点
			location = routemapService.repositionFP(location);
		}
		result.put("fpX", location.getPointX());
		result.put("fpY", location.getPointY());
		result.put("msg", 1);
		return result;
	}
	
	/**
	 * 小窗口-切换预案-获取预案梗概
	 * @param emergencyPlan
	 * @return
	 */
	@RequestMapping("/planSketch")
	@ResponseBody
	public JSONObject planSketch(@RequestBody List<EmergencyPlan> emergencyPlans){
		JSONObject result = new JSONObject();
		List<EmergencyPlan> skchPlans = routemapService.srchPlanSkch(emergencyPlans);
		result.put("msg", 1);
		result.put("skchPlans", skchPlans);
		return result;
	}
	
	/**
	 * 小窗口-获取当前预案的详情
	 * @param emergencyPlan
	 * @return
	 */
	@RequestMapping("/planDetInfo")
	@ResponseBody
	public JSONObject planDetInfo(@RequestBody Location location){			//这个入参没有实际意义，只是为了绑定方便和节约时间，里面只有当前预案的ID
		JSONObject result = routemapService.srchPlanDet(location.getRtID());
		return result;
	}	
	
}
