package com.teamJ3.homepage.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class NoticeDao {
	@Autowired
    private SqlSessionTemplate sqlSession;
      
    public String getNow() {
        // TODO Auto-generated method stub
        return sqlSession.selectOne("com.teamJ3.homepage.dao.TestMapper.getNow");
    }
}
