package cn.kepu.elearning.service;

import java.util.List;

import cn.kepu.elearning.pojo.ShotCutImg;

public interface IShotCutService {

	
	List<ShotCutImg> getAllShots();
	
	void delImg(Integer scImgId);
	
	List<ShotCutImg> srchImgs(Integer kwType, String keyWord,Integer imgType, String recTime_st, String recTime_ed);
}
