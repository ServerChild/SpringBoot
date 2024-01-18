package com.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.Member;
import com.study.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	// 데이터 추가
	public Member insert(Member member) {
		// save() : insert 해주는 메소드
		Member rMember = memberRepository.save(member);
		
		return rMember;
	}

	/*
	 	Optional<T> : NullPointerException을 방지하기 위해 사용
	 	  - 기존의 반환값 타입 T에 Optional<T>를 Wrapping 하여, null 대신 Optional 안에 빈 타입 객체를 돌려줌
	 	  
	 	  - 예시) Member member = memberRepository.findById("userid"); -> 값이 없을 경우
	 	  			member.getUsername(); -> 호출 시 NullpointerException 발생
	*/
	// 특정 id 조회
	public Optional<Member> select(Long id) {
		// findById() : Entity에서 @Id가 붙은 필드를 의미
		Optional<Member> member = memberRepository.findById(id);
		
		return member;
	}

	// 전체 조회
	public List<Member> selectAll() {
		return memberRepository.findAll();
	}

	// 특정 id 삭제
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}

	public Member update(Member member) {
		// update는 별도로 없기 때문에 insert와 동일하게 save() 사용
		// @Id 필드의 값이 DB에 있으면 update, 없으면 insert 해줌
		return memberRepository.save(member);
	}
}
