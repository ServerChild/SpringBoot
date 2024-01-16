package exam5;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name="JpaMember5")
@Getter
@ToString
public class Member5 {
	@Id
	private String email;
	
	private String name;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	
	// 생성자
	public Member5() { }

	public Member5(String email, String name, LocalDate createDate) {
		this.email = email;
		this.name = name;
		this.createDate = createDate;
	}
	
}
