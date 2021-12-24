package kr.co.project;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.project.model.vo.UserDTO;
import kr.co.project.service.UserSv;

@Controller
public class UserController {
	@Resource(name = "userSv")
	private UserSv userSv;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserDTO dto, HttpSession session) {
		Object obj = userSv.selectUserSv(dto);
		
		String returnPage = "login";
		if(obj != null) {
			returnPage = "redirect:/";
			session.setAttribute("user", obj);
		}
		
		return returnPage;
	}
	
	@RequestMapping(value = "sign-out")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
