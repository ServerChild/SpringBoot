package com.study.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@PostMapping("rinsert.bo")
	@ResponseBody
	public Reply rinsert(Reply reply) {
		return replyService.rinsert(reply);
	}
}
