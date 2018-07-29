package com.teamJ3.homepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teamJ3.homepage.dto.Board;
import com.teamJ3.homepage.dto.Notice;
import com.teamJ3.homepage.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger log = LoggerFactory
			.getLogger(NoticeController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/board/board-notice", method = RequestMethod.GET)
	public ModelAndView boardNotice(HttpServletRequest request) {
		log.info("board-notice 페이지 로딩중...");
		
		List<Board> list = service.selectBoardList();
		ModelAndView mav = new ModelAndView();
		mav = new ModelAndView();
		mav.setViewName("board-board");
		mav.addObject("list",list);
		return mav;
	}
	
		
	@RequestMapping(value = "/board/board-write", method = RequestMethod.GET)
	public ModelAndView boardWrite(HttpServletRequest request, ModelAndView mav) {
		log.info("board-write 페이지 로딩중...");
		mav = new ModelAndView();
		mav.setViewName("board-board-write");
		mav.addObject("Board", new Board());
		return mav;
	}
	
	
	@RequestMapping(value = "/board/board-info", method = RequestMethod.GET)
	public ModelAndView boardInfo(HttpServletRequest request, ModelAndView mav,int boardId) {
		log.info("board-info 페이지 로딩중..." + boardId);
		mav = new ModelAndView();
		Board boardInfo = service.selectBoardInfo(boardId);
		mav.addObject("boardInfo", boardInfo);
		mav.setViewName("board-board-info");
		return mav;
	}
	
	
	@RequestMapping(value = "/board/board-estimate", method = RequestMethod.GET)
	public ModelAndView boardEstimate(HttpServletRequest request, ModelAndView mav) {
		log.info("board-estimate 페이지 로딩중...");
		mav = new ModelAndView();
		mav.setViewName("board-estimate");
		return mav;
	}
	
	
	@RequestMapping(value = "/board/board-submit", method = RequestMethod.POST)
	public String boardSubmit(Board board, ModelAndView mav) {
		log.info("board-Submit 로딩중...");
		System.out.println(board.getBoard_contents());
		board.setBoard_writer("admin");
		service.insertBoard(board);
		return "redirect:/board/board-notice";
	}
	
	
}
