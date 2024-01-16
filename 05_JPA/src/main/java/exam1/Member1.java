package exam1;

import java.time.LocalDate;

import jakarta.persistence.*;

// 필수
@Entity
public class Member1 {
	@Id // 필수 : primary key 지정
	@GeneratedValue // 자동으로 PK 값을 증가시켜줌(시퀀스 사용)
	private Long id;
	
	private String username;
	
	/*
	 	@Column 어노테이션 속성
	 	  - name : 컬럼이름 지정(생략 시 변수명과 동일하게 매핑)
	 	  - unique : unique 제약조건 설정(기본값 false)
	 	  - nullable : null 상태 허용 여부(기본값 false)
	 	  - insertable : insert 할 때 컬럼 포함 여부(기본값 true)
	 	  - updateable : update 할 때 컬럼 포함 여부(기본값 true)
	 	  - length : 문자열 타입의 컬럼 길이 지정(기본값 255)
	 	  - columnDefinition : 컬럼에 대한 DDL문 직접 기술
	 	  	  + ex) @Column(columnDefinition="varchar2(200) default '1'")
	*/
	
	/*
	 	- LocalDate : 날짜
	 	- LocalDateTime : 날짜 + 시간
	*/
	@Column(name="create_date")
	private LocalDate createDate;
	
	
	// 생성자
	public Member1() { } // 필수

	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
	
}
