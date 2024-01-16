package exam2;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="JpaMember2") // 테이블명
public class Member2 {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	
	// 생성자
	public Member2() { } // 필수

	public Member2(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
