package kr.co.project.bbs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.project.bbs.model.sql.BbsDao;

@Service("bbsSv")
public class BbsSvImpl implements BbsSv {
	@Resource(name = "bbsDao")
	private BbsDao bbsDao;

	@Override
	public List<Object> selectBbsAllSv() {
		return bbsDao.selectBbsAll();
	}
	
	@Override
	public List<Object> selectBbsSearchSv(Object obj) {
		return bbsDao.selectBbsSearch(obj);
	}
	
	@Override
	public List<Object> selectBbsReply(Object obj) {
		return bbsDao.selectBbsReply(obj);
	}

	@Override
	public int insertBbsSv(Object obj) {
		return bbsDao.insertBbs(obj);
	}
	
	@Override
	public int insertBbsReplySv(Object obj) {
		return bbsDao.insertBbsReply(obj);
	}

	@Override
	public int updateBbsViewCntSv(Object obj) {
		return bbsDao.updateBbsViewCnt(obj);
	}
	
	@Override
	public int updateBbsSv(Object obj) {
		return bbsDao.updateBbs(obj);
	}

	@Override
	public int deleteBbsSv(Object obj) {
		return bbsDao.deleteBbs(obj);
	}

	@Override
	public int deleteBbsReplySv(Object obj) {
		return bbsDao.deleteBbsReply(obj);
	}

}
