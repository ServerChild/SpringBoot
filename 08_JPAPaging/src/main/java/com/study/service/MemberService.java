package com.study.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.study.domain.Member;
import com.study.repository.MemberRepository;


@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	// Member 추가
	public void insert() {
		Member member;
		
		member = new Member("test1@test.com", "이순신");
		memberRepository.save(member);
		
		member = new Member("test2@test.com", "김아무개");
		memberRepository.save(member);
		
		member = new Member("test3@test.com", "박아무개");
		memberRepository.save(member);
		
		member = new Member("test4@test.com", "이아무개");
		memberRepository.save(member);
		
		member = new Member("test5@test.com", "홍아무개");
		memberRepository.save(member);
		
		member = new Member("test6@test.com", "감아무개");
		memberRepository.save(member);
		
		member = new Member("test7@test.com", "방아무개");
		memberRepository.save(member);
		
		member = new Member("test8@test.com", "호아무개");
		memberRepository.save(member);
		
		member = new Member("test9@test.com", "하아무개");
		memberRepository.save(member);
		
		member = new Member("test10@test.com", "부아무개");
		memberRepository.save(member);
	}

	// 전체 조회
	public List<Member> selectAll() {
		return memberRepository.findAll();
	}

	// 특정 ID 조회
	public Optional<Member> selectById(Long id) {
		return memberRepository.findById(id);
	}

	// 특정 Email 조회
	public Optional<Member> selectByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	// 특정 이름 조회
	public Optional<Member> selectByName(String name) {
		return memberRepository.findByName(name);
	}

	// 특정 단어를 포함한 이름 조회
	public List<Member> selectByNameLike(String name) {
		return memberRepository.findByNameLike(name);
	}

	// 특정 단어를 포함한 이름 조회(내림차순)
	public List<Member> selectByNameLikeDesc(String name) {
		return memberRepository.findByNameLikeOrderByNameDesc(name);
	}

	public List<Member> selectByNameLike(String name, Sort sort) {
		return memberRepository.selectByNameLike(name, sort);
	}
	
	
}
