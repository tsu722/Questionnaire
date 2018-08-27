package cn.kepu.elearning.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.kepu.elearning.pojo.Activity;

public interface IActivityService {

	void saveNewAct(Activity activity,MultipartFile actPic) throws IOException;
	
	List<Activity> getAllActs();
	
	List<Object> actsListJson();
}
