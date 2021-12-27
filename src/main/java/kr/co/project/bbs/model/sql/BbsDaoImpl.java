package kr.co.project.bbs.model.sql;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("bbsDao")
public class BbsDaoImpl implements BbsDao {
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<Object> selectBbsAll() {
		return sqlSession.selectList("bbs.selectBbsAll");
	}

}
