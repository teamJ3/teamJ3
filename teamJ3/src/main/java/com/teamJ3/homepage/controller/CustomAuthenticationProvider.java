package com.teamJ3.homepage.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.teamJ3.homepage.service.LoginService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService service;

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean supports(Class<?> authentication) {
    	return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = (String) authentication.getPrincipal();
		String pw = (String) authentication.getCredentials();
		
		try {
		    id = new String(id.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
		    log.error(e.getMessage(), e);
		}
	
		if (id.length() < 1 || pw.length() < 1)
		    return null;
		else {
			log.info("Welcome authenticate! {}", id + "/" + pw);
		}
		
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("pw", pw);
	
		int ret = service.selectLoginVerifyOne(param);
	
		if (ret == 2) {
		    log.info("Welcome authenticate! {}", id);
		    List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		    roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(id, pw, roles);
		    
		    CustomUserDetails userDetails = new CustomUserDetails(id, pw);

		    HashMap<String, Object> map = service.selectUserOne(id);
		    
		    userDetails.setUserId(map.get("users_id").toString());
		    userDetails.setUsername(map.get("users_name").toString());
		    userDetails.setUserAuth(map.get("users_auth").toString());
		    
		    result.setDetails(userDetails);
		    
		    return result;
		} else {
		    return null;
		}
    }
}