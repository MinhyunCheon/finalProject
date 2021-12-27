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
			String dest = (String)session.getAttribute("dest");
			String qString = (String) session.getAttribute("qString");
			System.out.println(dest);
			// redirect:/ 뒤에 이전 경로를 붙이면 redirect:/regist가 아닌 ip가 생략된 regist/만 입력되어 오류 발생
			returnPage = "redirect:" + ((dest != null) ? dest : "/") + (qString != null ? "?" + qString : "");
			session.setAttribute("user", obj);
			session.removeAttribute("dest");
			session.removeAttribute("qString");
		}
		
		return returnPage;
	}
	
	@RequestMapping(value = "sign-out")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
