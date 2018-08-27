package cn.kepu.elearning.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.kepu.elearning.service.IUserService;



/**
 * 本控制器主要实现一些非功能性默认跳转、基本权限判断、日志管理功能
 * @author SilWhale_Make
 *
 */
@Controller
public class DefaultController {
	
		@Autowired
		@Qualifier("userService")
		private IUserService userService;
	
		
		/**
		 * 跳转至管理员管理面板
		 * @return
		 */
		@RequestMapping("/mgrPanel")
		public String toMgrPanel(HttpSession session){
			if (session.getAttribute("eosoperatorID") != null) {
				int userID = Integer.parseInt(session.getAttribute("eosoperatorID").toString());
				if (userService.chkUserInfo(userID).getUserRight() > 1) {
					return "mgrPanel";
				} else {
					return "gnrUserPanel";
				}
			} else {
				return "errorPages/noLogin";
			}			
		}					
	
}
