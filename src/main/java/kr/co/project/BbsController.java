package kr.co.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.project.bbs.model.vo.BbsVO;
import kr.co.project.bbs.service.BbsSv;

@Controller
public class BbsController {
	@Resource(name = "bbsSv")
	private BbsSv bbsSv;
	
	@RequestMapping(value = "listAll", method = RequestMethod.GET)
	public ModelAndView getListAll() {
		return new ModelAndView("listAll", "list", bbsSv.selectBbsAllSv());
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public ModelAndView read(BbsVO bv) {
		return new ModelAndView("read", "bbs", bv);
	}
	
}
