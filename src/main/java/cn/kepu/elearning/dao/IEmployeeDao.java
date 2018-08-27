package cn.kepu.elearning.dao;

import org.apache.ibatis.annotations.Param;

import cn.kepu.elearning.pojo.EosorgTEmployee;

public interface IEmployeeDao {
		
	EosorgTEmployee selectEmpByOpId(@Param("operatorID")Integer operatorID);
		

}
