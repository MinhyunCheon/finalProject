package kr.co.project.model.sql;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public Object selectUser(Object obj) {
		return sqlSession.selectOne("user.selectUser", obj);
	}

}
