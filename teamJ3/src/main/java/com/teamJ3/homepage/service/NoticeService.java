package com.teamJ3.homepage.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.teamJ3.homepage.dao.NoticeDao;

public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	public String getNow() {
		return noticeDao.getNow();
	}
}
