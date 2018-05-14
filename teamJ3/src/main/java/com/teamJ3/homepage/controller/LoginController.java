package com.teamJ3.homepage.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.teamJ3.homepage.service.LoginService;

@Controller
@SessionAttributes({ "teamJ3Session", "teamJ3SessionId" })
public class LoginController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/login")
    public ModelAndView root(Locale locale, ModelAndView mv, HttpServletRequest request) {
    	ModelMap modelMap = mv.getModelMap();
    	modelMap.put("updatePwd", "/update-pwd");
		mv.setViewName("login");
		return mv;
    }
    
    @RequestMapping(value = "/login-check", method = RequestMethod.GET)
    public String loginCheck(RedirectAttributes ra) throws Exception {
    	CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
    	System.out.println(userDetails.getPassword());
    	
    	ra.addFlashAttribute("isVerifyIpAddr", false);
    	
    	return "redirect:/";
    }

    @RequestMapping(value = "/login-fail", method = RequestMethod.GET)
    public String loginFail(RedirectAttributes ra) {
		ra.addFlashAttribute("isLoginFail", true);
		return "redirect:/";
    }

    @RequestMapping(value = "/login-success", method = RequestMethod.GET)
    public ModelAndView loginSuccess(HttpServletRequest request, HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		log.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUserId());
		
		session.setAttribute("teamJ3Session", session.getId());
		session.setAttribute("teamJ3SessionId", session.getId());
		
		ModelAndView mv = new ModelAndView();

	    System.out.println(session.getId());
	    System.out.println(userDetails.getUserId());
	    System.out.println(userDetails.getUsername());
	    System.out.println(userDetails.getPassword());
	    System.out.println(userDetails.getUserAuth());

	    //로그인 이력
		service.insertUserLog(userDetails.getUserId(), session.getId());

		mv.addObject("userId", userDetails.getUserId());
		mv.addObject("username", userDetails.getUsername());
		mv.addObject("userAuth", userDetails.getUserAuth());
		mv.addObject("currentTimeMills", String.valueOf(System.currentTimeMillis()));
		mv.addObject("keepLoginUrl", "/keep-login");
		
		mv.setViewName("index");
		return mv;
    }

    /**
     * 리턴값 : 0/초기비밀번호와 같음, 1/비밀번호가 정상 갱신됨, 2/비밀번호가 공백이거나 6자이하임, 3/시스템오류로 비밀번호
     * 갱신되지 않음
     * 
     * @param param
     * @param session
     * @return
     */
    @RequestMapping(value = "/update-pwd", method = RequestMethod.POST)
    public @ResponseBody int updatePwd(@RequestBody Map<String, Object> param, HttpSession session) {
		int ret = String.valueOf(param.get("newPw")).length() < 4 ? 2 : service.selectCheckDefaultPwdOne(param);
	
		if (ret == 1) {
		    if (service.updateUserPwd(param)) {
		    	User user = service.selectUserInfo(param);
		    	session.setAttribute("currentUser", user);
		    } else {
		    	ret = 3;
		    }
		}
	
		return ret;
    }
	
    @RequestMapping(value = "/keep-login", method = RequestMethod.POST)
    public @ResponseBody boolean keepLogin(@RequestBody Map<String, Object> param, HttpSession session) {
		log.debug("Dummy called for keeping login state.");
		return true;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpSession session) {
    	//로그아웃 이력
    	service.updateUserLog(session.getId());
    	
		RedirectView rv = new RedirectView("logout-redirect");
		rv.setExposeModelAttributes(false);
		return new ModelAndView(rv);
    }

}
