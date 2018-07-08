package com.teamJ3.homepage.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamJ3.homepage.dto.Notice;

@Repository
public class NoticeDao {
	@Autowired
    private SqlSessionTemplate sqlSession;
      
	public List<Notice> selectNoticeList() {
		System.out.println("Daob");
		return sqlSession.selectList("com.teamJ3.homepage.dao.NoticeMapper.selectNoticeList");
	}
	
}
