package cn.kepu.elearning.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.kepu.elearning.pojo.Eosoperator;
import cn.kepu.elearning.pojo.GnrUser;
import cn.kepu.elearning.pojo.LogRecord;
import cn.kepu.elearning.pojo.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    GnrUser selUserInfo(Integer gnrUserId);			//根据用ID获取单个用户信息
    
    GnrUser loginWithUserIdNPwd(@Param("gnrUserName")String gnrUserName, @Param("gnrUserPwd")String gnrUserPwd);
    
    Eosoperator selOptrByIdWithEmpInfo (@Param("operatorID")Integer operatorID);
    
    List<GnrUser> selAllUsers();
    
    void delUserByID(Integer gnrUserId);
    
    void updateUser(GnrUser user);
    
    public List<GnrUser> selUsersByName(String gnrUserName);
    
    public List<GnrUser> selUsersByDep(String gusClassName);
    
    List<LogRecord> selAllLogs();
    
    List<LogRecord> selLogsByUserName(@Param("userName")String userName, @Param("startDate")String startDate, @Param("endDate")String endDate);
    
    List<LogRecord> selLogsByLogLev(@Param("logLev")String logLev, @Param("startDate")String startDate, @Param("endDate")String endDate);
    
    List<LogRecord> selLogsByLogCont(@Param("logMsg")String logMsg, @Param("startDate")String startDate, @Param("endDate")String endDate);
    
    List<LogRecord> selLogsByUserID(@Param("userID")Integer userID, @Param("startDate")String startDate, @Param("endDate")String endDate);
    
    List<LogRecord> selLogsByDate(@Param("startDate")String startDate, @Param("endDate")String endDate);
    
    void istNewUser(GnrUser user);
}