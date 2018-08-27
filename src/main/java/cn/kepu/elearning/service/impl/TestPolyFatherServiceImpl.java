package cn.kepu.elearning.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kepu.elearning.dao.ITestPolyFatherDao;

import cn.kepu.elearning.pojo.testPolySon;
import cn.kepu.elearning.service.ITestPolyFatherService;

@Service("itestPolyFatherService")
public class TestPolyFatherServiceImpl implements ITestPolyFatherService{
	
	@Autowired
	private ITestPolyFatherDao testPolyFatherDao;
	
	public List<testPolySon> getSons(){
		return testPolyFatherDao.selSonsAsFather();
	}
	
	
	
}
