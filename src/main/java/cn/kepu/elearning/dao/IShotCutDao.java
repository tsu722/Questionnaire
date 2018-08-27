package cn.kepu.elearning.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.kepu.elearning.pojo.Crew;
import cn.kepu.elearning.pojo.MonitorPoint;
import cn.kepu.elearning.pojo.ShotCutImg;

public interface IShotCutDao {

	ShotCutImg selImgByID(Integer scImgId);
	
	List<ShotCutImg> selAllShots();
	
	MonitorPoint selMptNameByID(Integer mptId);
	
	Crew selCrewNameByID(Integer crewID);
	
	void delImgByID(Integer scImgId);
	
	List<ShotCutImg> selImgsByMptID(@Param("mptId")Integer mptId, @Param("scImgType")Integer scImgType, @Param("startDate")String startDate, @Param("endDate")String endDate);
	
	List<MonitorPoint> selMptsByName(String mptName);
	
	List<ShotCutImg> selImgsByMptName(Map<String, Object> map);
	
	List<ShotCutImg> selImgsByTypeNDate(@Param("scImgType")Integer scImgType, @Param("startDate")String startDate, @Param("endDate")String endDate);
	
}
