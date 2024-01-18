package com.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="MEMBERJPA02")
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String email;

	public Member(String email, String name) {
		this.email = email;
		this.name = name;
	}
	
}
