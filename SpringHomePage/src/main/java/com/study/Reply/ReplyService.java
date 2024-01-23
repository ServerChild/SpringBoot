package com.study.Reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

	@Autowired
	ReplyRepository replyRepository;
	
	public List<Reply> findAllByRefBnoOrderByRnoDesc(Long bno) {
		return replyRepository.findAllByRefBnoOrderByRnoDesc(bno);
	}
	
	public Reply rinsert(Reply reply) {
		return replyRepository.save(reply);
	}
}
