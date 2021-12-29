package kr.co.project.bbs.service;

import java.util.List;

public interface BbsSv {
	public List<Object> selectBbsAllSv();
	public List<Object> selectBbsSearchSv(Object obj);
	public List<Object> selectBbsReply(Object obj);
	public int insertBbsSv(Object obj);
	public int insertBbsReplySv(Object obj);
	public int updateBbsViewCntSv(Object obj);
	public int updateBbsSv(Object obj);
	public int deleteBbsSv(Object obj);
	public int deleteBbsReplySv(Object obj);
}
