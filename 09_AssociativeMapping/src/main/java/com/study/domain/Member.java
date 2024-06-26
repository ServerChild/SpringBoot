package com.study.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="MEMBERAM")
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
	private String id;
	
	private String name;
	
	private String password;
	
	private String email;
	
	// 자동으로 생성되는 시간 넣어줌
	@CreatedDate 
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	
	// 엔티티가 수정될 때 수정된 시간 넣어줌
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;
	
	/*
		* 자동으로 시간을 생성해주는 @CreatedDate 와 @LastModifiedDate 를 사용할 때 
			- 반드시 Entity에 @EntityListeners(AuditingEntityListener.class)를 어노테이션을 넣어줘야 함
			
			- main() 메소드가 있는 클래스에도 @EnableJpaAuditing 어노테이션을 넣어줘야 함
	*/

}
