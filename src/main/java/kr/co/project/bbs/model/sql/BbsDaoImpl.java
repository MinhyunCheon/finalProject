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

	@Override
	public int insertBbs(Object obj) {
		return sqlSession.insert("bbs.insertBbs", obj);
	}

	@Override
	public int updateBbsViewCnt(Object obj) {
		return sqlSession.update("bbs.updateBbsViewCnt", obj);
	}

}
