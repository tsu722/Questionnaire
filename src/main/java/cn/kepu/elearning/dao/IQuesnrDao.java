package cn.kepu.elearning.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.kepu.elearning.pojo.EosorgTOrganization;
import cn.kepu.elearning.pojo.TnAssignDept;
import cn.kepu.elearning.pojo.TnNeedsQuestionnaire;
import cn.kepu.elearning.pojo.TnQuestionnaireItem;
import cn.kepu.elearning.pojo.TnQuestionnaireItemChoice;



public interface IQuesnrDao {
		
		
		List<TnNeedsQuestionnaire> selAllQuesnrs();
		
		
//		void istQsnBscInfo(TnNeedsQuestionnaire tnNeedsQuestionnaire);
		
		
		int istQsnBscInfo(TnNeedsQuestionnaire tnNeedsQuestionnaire);
				
		int istQsnItm(TnQuestionnaireItem tnQuestionnaireItem);
		
		void istQsnCho(List<TnQuestionnaireItemChoice> choices);		
		
		List<TnQuestionnaireItem> selQsnItmByQsnId(Integer basicInfoID);
		
		List<TnQuestionnaireItemChoice> selItmChoByItmId(Integer itemID);
		
		//----------------------------以下方法用于预览-------------------------------------
		
		TnNeedsQuestionnaire selQsnBscInfo(Integer quesnrID);
		
		List<TnAssignDept> selAssnDeptByQIDWithOrg(@Param("quesnrID") Integer quesnrID);
		
		
}
