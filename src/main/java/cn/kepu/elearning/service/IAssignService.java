package cn.kepu.elearning.service;

import java.util.List;

import cn.kepu.elearning.pojo.EosorgTOrganization;
import cn.kepu.elearning.pojo.TnAssignDept;
import cn.kepu.elearning.pojo.ZtreeNode;

public interface IAssignService {
			
	
	
	EosorgTOrganization getOrg(Integer orgID);
	
	List<EosorgTOrganization> getChilOrgs(Integer orgId);	
	
	
	/**
	 * 根据ID获取单个Organization对象
	 * @param orgID
	 * @return EosorgTOrganization
	 */
	EosorgTOrganization getSingleOrg(Integer orgID);
	
	List<Object> getOrgsToZTree(Integer rootId);
	
	void buildZtree(List<EosorgTOrganization> subDeps, Integer parentNodeId);
	
	void saveAssnDept(TnAssignDept assignDept);
	
	List<TnAssignDept> getAssnDepts(Integer QsnrId);
	
	void transNSaveAssnDept(List<ZtreeNode> ztreeNodes);
}
