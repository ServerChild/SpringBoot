package com.study.Reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

	List<Reply> findAllByRefBnoOrderByRnoDesc(Long bno);

}