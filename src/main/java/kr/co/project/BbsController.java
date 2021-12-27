package kr.co.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.project.bbs.model.vo.BbsDTO;
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
		if(bbsSv.updateBbsSv(bv) != 1) System.out.println("ViewCnt update Error");
		return new ModelAndView("read", "bbs", bv);
	}
	
	@RequestMapping(value = "registForm", method = RequestMethod.GET)
	public String registForm() {
		return "registForm";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String regist(BbsDTO bt) {
		return "redirect:/" + (bbsSv.insertBbsSv(bt) == 1 ? "listAll" : "registForm");
	}
}
