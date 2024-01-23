package com.study.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity(name="BOARDAM")
@EntityListeners(AuditingEntityListener.class)
public class Board {
	@Id
	@GeneratedValue
	private Long bno;
	
	private String title;
	
	private String content;
	
	// 자동으로 생성되는 시간 넣어줌
	@CreatedDate 
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	// 엔티티가 수정될 때 수정된 시간 넣어줌
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;
	
	
	@ManyToOne // 다 대 일 관계(N : 1)
	@JoinColumn(name="writer")
	private Member member; // Member객체 중 @Id가 붙어있는 필드의 값이 들어감
}
