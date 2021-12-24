package kr.co.project.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.project.model.sql.UserDao;

@Service("userSv")
public class UserSvImpl implements UserSv {
	@Resource(name = "userDao")
	private UserDao dao;

	@Override
	public Object selectUserSv(Object obj) {
		return dao.selectUser(obj);
	}

}
