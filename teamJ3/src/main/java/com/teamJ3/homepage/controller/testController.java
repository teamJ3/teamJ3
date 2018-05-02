package com.teamJ3.homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class testController {

	private static final Logger log = LoggerFactory
			.getLogger(testController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, ModelAndView mav) {
		log.info("첫 index 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("index");

		return mav;
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView errorPage(HttpServletRequest request, ModelAndView mav) {
		log.info("404 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("404");

		return mav;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request, ModelAndView mav) {
		log.info("about 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("about");

		return mav;
	}

	@RequestMapping(value = "/blog-home-1", method = RequestMethod.GET)
	public ModelAndView blogHomeOne(HttpServletRequest request, ModelAndView mav) {
		log.info("blogHomeOne 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("blog-home-1");

		return mav;
	}

	@RequestMapping(value = "/blog-home-2", method = RequestMethod.GET)
	public ModelAndView blogHomeTwo(HttpServletRequest request, ModelAndView mav) {
		log.info("blogHomeTwo 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("blog-home-2");

		return mav;
	}

	@RequestMapping(value = "/blog-post", method = RequestMethod.GET)
	public ModelAndView blogPost(HttpServletRequest request, ModelAndView mav) {
		log.info("blogPost 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("blog-pos");

		return mav;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(HttpServletRequest request, ModelAndView mav) {
		log.info("contact 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("contact");

		return mav;
	}

	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public ModelAndView faq(HttpServletRequest request, ModelAndView mav) {
		log.info("faq 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("faq");

		return mav;
	}

	@RequestMapping(value = "/full-width", method = RequestMethod.GET)
	public ModelAndView fullWidth(HttpServletRequest request, ModelAndView mav) {
		log.info("fullWidth 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("full-width");

		return mav;
	}

	@RequestMapping(value = "/portfolio-1-col", method = RequestMethod.GET)
	public ModelAndView portfolioOneCol(HttpServletRequest request,
			ModelAndView mav) {
		log.info("portfolioOneCol 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("portfolio-1-col");

		return mav;
	}

	@RequestMapping(value = "/portfolio-2-col", method = RequestMethod.GET)
	public ModelAndView portfolioTWoCol(HttpServletRequest request,
			ModelAndView mav) {
		log.info("faq 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("portfolio-2-col");

		return mav;
	}

	@RequestMapping(value = "/portfolio-3-col", method = RequestMethod.GET)
	public ModelAndView portfolioThreeCol(HttpServletRequest request,
			ModelAndView mav) {
		log.info("portfolioThreeCol 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("portfolio-3-col");

		return mav;
	}

	@RequestMapping(value = "/portfolio-4-col", method = RequestMethod.GET)
	public ModelAndView portfolioFourCol(HttpServletRequest request,
			ModelAndView mav) {
		log.info("portfolioFourCol 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("portfolio-4-col");

		return mav;
	}

	@RequestMapping(value = "/portfolio-item", method = RequestMethod.GET)
	public ModelAndView portfolioItem(HttpServletRequest request,
			ModelAndView mav) {
		log.info("portfolioItem 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("portfolio-item");

		return mav;
	}

	@RequestMapping(value = "/pricing", method = RequestMethod.GET)
	public ModelAndView pricing(HttpServletRequest request,
			ModelAndView mav) {
		log.info("pricing 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("pricing");

		return mav;
	}

	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public ModelAndView services(HttpServletRequest request,
			ModelAndView mav) {
		log.info("services 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("services");

		return mav;
	}

	@RequestMapping(value = "/sidebar", method = RequestMethod.GET)
	public ModelAndView sidebar(HttpServletRequest request,
			ModelAndView mav) {
		log.info("sidebar 페이지 로딩중...");

		mav = new ModelAndView();
		mav.setViewName("sidebar");

		return mav;
	}
	
}
