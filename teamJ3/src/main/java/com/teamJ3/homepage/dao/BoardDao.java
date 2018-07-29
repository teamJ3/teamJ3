package com.teamJ3.homepage.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamJ3.homepage.dto.Board;

@Repository
public class BoardDao {
	@Autowired
    private SqlSessionTemplate sqlSession;
      
	public List<Board> selectBoardList() {

		return sqlSession.selectList("com.teamJ3.homepage.dao.BoardMapper.selectBoardList");
	}
	
	public int insertBoard(Board board){

		return sqlSession.insert("com.teamJ3.homepage.dao.BoardMapper.insertBoard", board);
	}
	public Board selectBoardInfo(int boardId){
		System.out.println("boardInfoDAO" + boardId);
		return sqlSession.selectOne("com.teamJ3.homepage.dao.BoardMapper.selectBoardInfo", boardId);
	}
}
