package com.teamJ3.homepage.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamJ3.homepage.dao.NoticeDao;
import com.teamJ3.homepage.dto.Notice;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	public List<Notice> selectNoticeList() {
		System.out.println("service");
		return noticeDao.selectNoticeList();
	}

}
