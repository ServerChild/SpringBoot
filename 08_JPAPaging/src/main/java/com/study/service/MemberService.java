package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.study.domain.Member;
import com.study.repository.MemberRepository;


@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	public Page<Member> selectByNameLike(String name, Pageable pageable) {
		Page<Member> member = memberRepository.findByNameLike(name, pageable);
		
		return member;
	}
}
