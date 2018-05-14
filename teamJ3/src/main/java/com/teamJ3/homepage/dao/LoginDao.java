package com.teamJ3.homepage.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

    public int selectLoginVerifyOne(Map<String, Object> param) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectLoginVerifyOne", param);
    }

    public User selectUserInfo(Map<String, Object> model) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectUserInfo", model);
    }
    
    public HashMap<String, Object> selectUserOne(String id) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectUserOne", id);
    }
    
    public String selectUserNameOne(String id) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectUserNameOne", id);
    }
    
    public String selectUserAuthOne(String id) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectUserAuthOne", id);
    }
    
    public String selectIpAddrOne(String id) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectIpAddrOne", id);
    }
    
    public int selectLoginCheckOne(Map<String, Object> model) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectLoginCheckOne", model);
    }

    public int selectCheckDefaultPwdOne(Map<String, Object> model) {
    	return sqlSession.selectOne("com.teamJ3.homepage.dao.LoginMapper.selectCheckDefaultPwdOne", model);
    }

    @Transactional
    public boolean updateUserPwd(Map<String, Object> model) {
		int ret = sqlSession.update("com.teamJ3.homepage.dao.LoginMapper.updateUserPwd", model);
		return ret == 1 ? true : false;
    }

    @Transactional
    public boolean insertUserLog(String userId, HashMap<String, String> param) {
    	int ret = sqlSession.insert("com.teamJ3.homepage.dao.LoginMapper.insertUserLog", param);
		
		return ret == 1 ? true : false;
    }
    
    @Transactional
    public boolean updateUserLog(String sessionId) {
    	HashMap<String, String> param = new HashMap<>();
    	param.put("sessionId", sessionId);
    	
    	int ret = sqlSession.insert("com.teamJ3.homepage.dao.LoginMapper.updateUserLog", param);
		
		return ret == 1 ? true : false;
    }
	
}
