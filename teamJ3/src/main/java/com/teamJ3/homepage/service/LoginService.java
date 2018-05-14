package com.teamJ3.homepage.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamJ3.homepage.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
    public int selectLoginVerifyOne(Map<String, Object> param) {
    	return loginDao.selectLoginVerifyOne(param);
    }

    public User selectUserInfo(Map<String, Object> model) {
    	return loginDao.selectUserInfo(model);
    }
    
    public HashMap<String, Object> selectUserOne(String id) {
    	return loginDao.selectUserOne(id);
    }
    
    public String selectUserNameOne(String id) {
    	return loginDao.selectUserNameOne(id);
    }
    
    public String selectUserAuthOne(String id) {
    	return loginDao.selectUserAuthOne(id);
    }
    
    public String selectIpAddrOne(String id) {
    	return loginDao.selectIpAddrOne(id);
    }
    
    public int selectLoginCheckOne(Map<String, Object> model) {
    	return loginDao.selectLoginCheckOne(model);
    }

    public int selectCheckDefaultPwdOne(Map<String, Object> model) {
    	return loginDao.selectCheckDefaultPwdOne(model);
    }

    @Transactional
    public boolean updateUserPwd(Map<String, Object> model) {
		return loginDao.updateUserPwd(model);
    }

    @Transactional
    public boolean insertUserLog(String userId, String sessionId) {
    	HashMap<String, String> param = new HashMap<>();
    	param.put("userId", userId);
    	param.put("sessionId", sessionId);
    	
    	return loginDao.insertUserLog(userId, param);
    }
    
    @Transactional
    public boolean updateUserLog(String sessionId) {
    	HashMap<String, String> param = new HashMap<>();
    	param.put("sessionId", sessionId);
    	
    	return loginDao.updateUserLog(sessionId);
    }
}
