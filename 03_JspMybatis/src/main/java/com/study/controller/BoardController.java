package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.Board;
import com.study.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "redirect:list";
	}
	
	
	/*
		* 요청 처리 후 응답 페이지로 결과를 담는 방법
		   1. Model
		       - 뷰로 전달하고자 하는 데이터를 맵형식(key=value)로 남을 수 있는 객체
		       - requestScope 임
		       		단, setAttribute가 아닌 addAttribute 메소드 이용
		       
		   2. ModelAndView
		       - Model 영역에 뷰로 전달하고자 하는 데이터를 맵형식(key=value)로 담을 수 있는 객체
		       	 View 영역은 응답 뷰에 대한 정보를 담을 수 있는 공간
		       	 
		       	 ex) public String list(ModelAndView mv) {
		       	 		List<Board> rlist = boardService.list();
		       	 		mv.addObject("boardList" , rlist)
		       	 		mv.setViewName("/list");
		       	 		return mv;
		       	 	 }
	*/
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", boardService.list());
		model.addAttribute("totalRecord", boardService.totalRecord());
		
		return "list";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	
	/*
		* 파라미터(요청시 전달값)을 받는 방법
		   1. HttpServletRequest를 이용하여 전달(기존 JSP/ Servlet때의 전달방식)
		   
		   2. @RequestParam 어노테이션 이용하는 방법
		   		- 속성
		   		   + value : URL에서 바인딩하게 될 값
		   		   + required(true | false) : 필수로 값을 전달하는지 전달하지 않는지(true일때 값이 안 들어오면 에러)
		   		   + defaultValue : 값이 없을 때 기본으로 사용할 값
		   		   
		   		   ++ @RequestParam("전달된 name(key)") 변수명 : defaultValue를 넣지 않을 때는 value는 생략 가능
		   		- 사용법
		   			@RequestParam(value="key" [, defaultValue="", required=true]) 자료형 변수명
		   			@RequestParam(value="key") -> 나머지 생략 가능
		   
		   3. 커멘트 객체 방식
		   		- dto 클래스 담는 방식 : 요청시 전달 값의 키(name)을 dto 클래스에 담고자 하는 필드명 작성
		   			+ 스프링컨테이너가 해당 객체의 기본 생성자를 생성 후, setter 메소드를 찾아 전달된 값을 해당 필드에 내부적으로 담아주는 원리
		   				++ 반드시 기본 생성자가 필요함
		   				++ setter 메소드가 필요함
		   				++ 키 이름이 필드명과 같아야 함
	   
	*/
	@PostMapping("/write")
	public String write(Board board) {
		boardService.insertBoard(board);

		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detailBoard(HttpServletRequest request, Model model) {
		// model.addAttribute("detailBoard", boardService.detailBoard(request.getParameter("no")));
		String no = request.getParameter("no");
		
		System.out.println("no : " + no);
		
		Board board = boardService.detailBoard(no);
		
		model.addAttribute("dBoard", board);
		
		return "detailForm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(value="no", defaultValue="1") String bno) {
		boardService.deleteBoard(bno);
		
		return "redirect:list";
	}
}
