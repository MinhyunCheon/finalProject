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

}