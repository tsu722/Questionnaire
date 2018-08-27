package cn.kepu.elearning.service;

import java.util.List;
import java.util.Queue;
import java.util.Vector;

import cn.kepu.elearning.pojo.MoniterVideo;
import cn.kepu.elearning.pojo.SrchBody;
import cn.kepu.elearning.pojo.VideoDetInfo;

public interface IMoniterVideoService {

	MoniterVideo getSigVid();
	
	List<Object> mVidsListJson();
	
	List<MoniterVideo> getAllmVids();
	
	List<Object> getDSrchResult(SrchBody srchBody);
	
	List<Object> GlobalSrch(SrchBody srchBody);
	
	void delVids(List<SrchBody> srchBodies);
	
	VideoDetInfo getVidDetInfo(Integer vidID, String videoType);
	
}
