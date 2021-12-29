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
	public List<Object> selectBbsSearch(Object obj) {
		return sqlSession.selectList("bbs.selectBbsSearch", obj);
	}
	
	@Override
	public List<Object> selectBbsReply(Object obj) {
		return sqlSession.selectList("bbs.selectBbsReply", obj);
	}

	@Override
	public int insertBbs(Object obj) {
		return sqlSession.insert("bbs.insertBbs", obj);
	}
	
	@Override
	public int insertBbsReply(Object obj) {
		return sqlSession.insert("bbs.insertBbsReply", obj);
	}

	@Override
	public int updateBbsViewCnt(Object obj) {
		return sqlSession.update("bbs.updateBbsViewCnt", obj);
	}
	
	@Override
	public int updateBbs(Object obj) {
		return sqlSession.update("bbs.updateBbs", obj);
	}

	@Override
	public int deleteBbs(Object obj) {
		return sqlSession.delete("bbs.deleteBbs", obj);
	}

	@Override
	public int deleteBbsReply(Object obj) {
		return sqlSession.delete("bbs.deleteBbsReply", obj);
	}

}
