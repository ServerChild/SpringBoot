package exam4;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name="JpaMember4")
@Getter
@ToString
public class Member4 {
	@Id
	private String email;
	
	private String name;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	
	// 생성자
	public Member4() { }

	public Member4(String email, String name, LocalDate createDate) {
		this.email = email;
		this.name = name;
		this.createDate = createDate;
	}
	
	
	// Update를 위한 메소드
	public void changeName(String newName) {
		name = newName;
	}
}
