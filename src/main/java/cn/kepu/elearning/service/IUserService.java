package cn.kepu.elearning.service;

import java.util.List;

import cn.kepu.elearning.pojo.Eosoperator;
import cn.kepu.elearning.pojo.GnrUser;
import cn.kepu.elearning.pojo.LogRecord;
import cn.kepu.elearning.pojo.User;

public interface IUserService {  
        
    public GnrUser login(String gnrUserName, String gnrUserPwd);  //0613
    
    public GnrUser chkUserInfo(Integer gnrUserId);
    
    public Eosoperator checkEmpInfo(Integer operatorID);
    
    public List<GnrUser> checkAllUsers();
    
    public void delUser(Integer gnrUserId);
    
    public GnrUser priUserInfo(Integer gnrUserId);
    
    public void rvdUserInfo(GnrUser user);
    
    public List<GnrUser> srchUsers(Integer kwType, String keyWord);
    
    public List<LogRecord> chkLogs();
    
    public List<LogRecord> srchLogs(Integer kwType, String keyWord, String recTime_st, String recTime_ed);

    public void signUpUser(GnrUser user);

}  
