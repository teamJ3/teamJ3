package com.teamJ3.homepage.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String userId;
	private String username;
    private String password;
    private String userAuth;

    public CustomUserDetails(String username, String password) {
		this.username = username;
		this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
    }
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    @Override
    public String getPassword() {
		return password;
    }
    
    public void setPassword(String password) {
		this.password = password;
	}

    @Override
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public String getUserAuth() {
    	return userAuth;
    }

    public void setUserAuth(String userAuth) {
    	this.userAuth = userAuth;
    }

    @Override
    public boolean isAccountNonExpired() {
    	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    	return true;
    }

    @Override
    public boolean isEnabled() {
    	return true;
    }
}