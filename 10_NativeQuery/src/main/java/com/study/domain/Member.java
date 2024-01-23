package com.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="JPAPAGING")
public class Member {
	@Id
	@SequenceGenerator(
		name="mySequence",
		sequenceName ="JPAPAGING_SEQ",
		initialValue =1,
		allocationSize =1
	)
	@GeneratedValue(generator="mySequence")
	private Long id;
	
	private String name;
	
	private String email;
}
