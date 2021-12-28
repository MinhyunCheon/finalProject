package kr.co.project.bbs.service;

import java.util.List;

public interface BbsSv {
	public List<Object> selectBbsAllSv();
	public List<Object> selectBbsSearchSv(Object obj);
	public int insertBbsSv(Object obj);
	public int updateBbsSv(Object obj);
}
