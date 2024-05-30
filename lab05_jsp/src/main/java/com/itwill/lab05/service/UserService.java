package com.itwill.lab05.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.repository.UserDao;

public enum UserService {
	INSTANCE;
	
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	//service 는 DAO를 사용한다.
	
	private UserDao userDao = UserDao.INSTANCE;
	
	// TODO: 회원가입에 필요한 메서드. userDao.insert() 호출.
	public int create(User user) {
		log.debug("create(user={})", user);
		int result = userDao.insert(user);
		log.debug("insert result={}", result);
		
		return result; // insert 된 행의 갯수를 리턴
	}
	//중복체크는 당장 안함
	
}
