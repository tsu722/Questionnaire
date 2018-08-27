package cn.kepu.elearning.service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.kepu.elearning.pojo.AlarmRecord;

public interface IAlarmRecordService {

	void startAlarming(Integer aRecId);
	
	void stopAlarming(Integer aRecId);
	
	List<Integer> chkAlarming();
	
	List<AlarmRecord> getAlrminRecs();
	
	JSONObject getUnhandledRes(Integer page, Integer limit);
	
	JSONObject getHandledRes(Integer page, Integer limit);
	
	JSONObject getErrRes(Integer page, Integer limit);
	
	void checkFirePoints();
	
	void cancelAlm(AlarmRecord alarmRecord);
	
	List<AlarmRecord> chkRecsInGps();			//GPS坐标的报警记录查询接口
	
}
