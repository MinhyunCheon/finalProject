package kr.co.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping(value = "pre.do")
	public void pre() {
		System.out.println("TestController pre");
	}
	
	@RequestMapping(value = "post.do")
	public void post() {
		System.out.println("TestContoller post");
	}
}
