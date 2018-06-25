package com.teamJ3.homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teamJ3.homepage.service.NoticeService;

@Controller
public class NoticeController {
	
	private static final Logger log = LoggerFactory
			.getLogger(NoticeController.class);
	
//	@Autowired
//	private NoticeService noticeService;
	
	@RequestMapping(value = "/board-notice", method = RequestMethod.GET)
	public ModelAndView boardNotice(HttpServletRequest request, ModelAndView mav) {
		
		log.info("board-notice 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("board-notice");

		return mav;
	}
	
		
	@RequestMapping(value = "/board-write", method = RequestMethod.GET)
	public ModelAndView boardWrite(HttpServletRequest request, ModelAndView mav) {
		
		log.info("board-write 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("board-write");

		return mav;
	}
	
	
	@RequestMapping(value = "/board-info", method = RequestMethod.GET)
	public ModelAndView boardInfo(HttpServletRequest request, ModelAndView mav) {
		
		log.info("board-info 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("board-info");

		return mav;
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/board-estimate", method = RequestMethod.GET)
	public ModelAndView boardEstimate(HttpServletRequest request, ModelAndView mav) {
		
		log.info("board-estimate 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("board-estimate");

		return mav;
	}
	
	
}
