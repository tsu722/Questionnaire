package cn.kepu.elearning.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.kepu.elearning.pojo.EosorgTOrganization;
import cn.kepu.elearning.pojo.TnAssignDept;

public interface IAssignDao {
				
	
	
	EosorgTOrganization selOrgByIdWithPrOrg(@Param("orgID") Integer orgID);
	
	EosorgTOrganization selPrOrgById(@Param("parentOrgID") Integer parentOrgID);
	
	List<EosorgTOrganization> selChilOrgsByPrId(Integer orgId);
	
	EosorgTOrganization selOrgById(Integer orgId);
	
	void istAssnDep(TnAssignDept assignDept);
	
	List<TnAssignDept> selAssnDeptsByQsnrId(@Param("QsnrId") Integer QsnrId);
	
	
}
