package com.teamJ3.homepage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamJ3.homepage.dao.TestDao;


@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public String getNow() {
		return testDao.getNow();
	}
}
