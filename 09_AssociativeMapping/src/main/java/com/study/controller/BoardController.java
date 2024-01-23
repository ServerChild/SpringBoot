package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.domain.Board;
import com.study.domain.Member;
import com.study.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/binsert")
	public String insert(Board board, Model model) {
		Member m = new Member();
		m.setId("user01");
		
		// 반드시 멤버 객체로 넘겨줘야 함(무조건 객체로)
		board.setMember(m);
		
		Board result = boardService.insert(board);
		
		model.addAttribute("board", result);
		
		// 값을 가져올때도 반드시 객체로 가져와야 함
		System.out.println("writer : " + result.getMember().getId());
		
		return "binsert";
	}
}
