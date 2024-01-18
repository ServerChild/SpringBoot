package com.study.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.domain.Member;
import com.study.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "menu";
	}
	
	@GetMapping("/insert")
	public String insert(@RequestParam("username") String username, Model model) {
		Member member1 = new Member();
		
		member1.setUsername(username);
		member1.setCreateDate(LocalDate.now());
		
		// 용도에 따른 생성자 만드는 것 -> 가독성 좋음
		Member member = Member.builder()
							.username(username)
							.createDate(LocalDate.now())
							.build();
		
		Member result = memberService.insert(member);
		
		model.addAttribute("member", result);
		
		return "insert";
	}
	
	@GetMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		Optional<Member> result = memberService.select(id);
		
		// 방법 1
		// get() : Wrapping으로 감싸진 것을 한번 빼낸 후 get 해와야 함
		// result.get().getUsername();
		// result.get().getId();
		
		// 방법 2
		// get() : Wrapping된걸 받았을 때 해도 o
		// Member member = memberService.select(id).get();
		// model.addAttribute("m", member);
		
		// isPresent() : 데이터가 있는지 없는지 체크
		if(result.isPresent()) {
			model.addAttribute("member", result.get()); // Member형으로 넘겨줌
		} else {
			model.addAttribute("member", null);
		}
		
		return "select";
	}
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		// List<Member> list = memberService.selectAll();
		
		model.addAttribute("members", memberService.selectAll());
		
		return "selectAll";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		
		return "redirect:selectAll";
	}
	
	@GetMapping("/update")
	public String update(Member member, Model model) {
		model.addAttribute("member", memberService.update(member));
		
		return "update";
	}
}
