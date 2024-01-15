package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Security Welcome";
	}
	
	@RequestMapping("/admin/welcome")
	public String welcome1() {
		return "admin/welcome1";
	}
	
	@RequestMapping("/member/welcome")
	public String welcome2() {
		return "member/welcome2";
	}
	
	@RequestMapping("/guest/welcome")
	public String welcome3() {
		return "guest/welcome3";
	}
	
	// security에서는 GetMapping이나 RequestMapping으로 해야함
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "security/loginForm";
	}
}
