package com.teamJ3.homepage.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamJ3.homepage.dao.BoardDao;
import com.teamJ3.homepage.dto.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<Board> selectBoardList() {
		
		return boardDao.selectBoardList();
	}
	
	public int insertBoard(Board board){
	
		return boardDao.insertBoard(board);
	}
	
	public Board selectBoardInfo(int boardId){
		System.out.println("boardInfo service" + boardId);
		return boardDao.selectBoardInfo(boardId);
	}

}
