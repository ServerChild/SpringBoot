package com.study.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	// JPQL 쿼리 : from 뒤에는 영속성에 있는 엔티티명(DB 테이블 아님, 반드시 대문자로)
	// Service에서 보내는 name 값이 name2로 저장되며, :name1 은 @Param으로 넘어온 이름과 동일하게 적어야 함
	@Query("SELECT m FROM JPAPAGING m WHERE m.name LIKE :name1 ORDER BY m.id DESC")
	List<Member> findMembers(@Param("name1") String name2);

	@Query("SELECT m FROM JPAPAGING m WHERE m.name LIKE :name1")
	List<Member> findMembers(@Param("name1") String name, Sort sort);
	
	@Query("SELECT m FROM JPAPAGING m WHERE m.name LIKE :name1")
	Page<Member> findMembers(@Param("name1") String name, Pageable pageable);
	
	// 일반 SQL 쿼리
	@Query(value="SELECT * FROM JPAPAGING WHERE NAME LIKE :name1 ORDER BY id DESC", nativeQuery=true)
	List<Member> findMembersNative(@Param("name1") String name);
}
