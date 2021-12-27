package kr.co.project.bbs.model.sql;

import java.util.List;

public interface BbsDao {
	public List<Object> selectBbsAll();
	public int insertBbs(Object obj);
	public int updateBbsViewCnt(Object obj);
}
