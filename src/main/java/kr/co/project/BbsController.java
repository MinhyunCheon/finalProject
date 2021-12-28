package kr.co.project;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.project.bbs.model.vo.BbsDTO;
import kr.co.project.bbs.model.vo.BbsSearchDTO;
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
		if(bbsSv.updateBbsViewCntSv(bv) != 1) System.out.println("ViewCnt update Error");
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
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<Object> search(BbsSearchDTO bsd) {
		return bbsSv.selectBbsSearchSv(bsd);
	}
	
	@RequestMapping(value = "deleteBbs", method = RequestMethod.GET)
	public String deleteBbs(BbsVO bv) {
		bbsSv.deleteBbsSv(bv);
		return "redirect:/listAll";
	}
	
	@RequestMapping(value = "modifyForm", method = RequestMethod.GET)
	public ModelAndView modifyForm(BbsVO bv) {
		return new ModelAndView("modifyForm", "bbs", bv);
	}
	
	@RequestMapping(value = "modifyBbs", method = RequestMethod.POST)
	public ModelAndView modify(BbsVO bv) {
		bbsSv.updateBbsSv(bv);
		return new ModelAndView("read", "bbs", bv);
	}
}
