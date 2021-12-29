package kr.co.project.bbs.model.sql;

import java.util.List;

public interface BbsDao {
	public List<Object> selectBbsAll();
	public List<Object> selectBbsSearch(Object obj);
	public List<Object> selectBbsReply(Object obj);
	public int insertBbs(Object obj);
	public int insertBbsReply(Object obj);
	public int updateBbsViewCnt(Object obj);
	public int updateBbs(Object obj);
	public int deleteBbs(Object obj);
}
