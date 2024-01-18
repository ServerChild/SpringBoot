package com.study.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByEmail(String email);
	
	Optional<Member> findByName(String name);
	
	List<Member> findByNameLike(String name);

	List<Member> findByNameLikeOrderByNameDesc(String name);
	
	// order by가 여러개 들어가는 경우 -> 필드명[ASC|DESC]을 이어서 적음
	// List<Member> findByNameLikeOrderByNameAscEmailDesc(String name);

	List<Member> selectByNameLike(String name, Sort sort);
}
