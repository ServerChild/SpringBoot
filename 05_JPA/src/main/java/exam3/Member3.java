package exam3;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="JpaMember3")
public class Member3 {
	@Id
	@SequenceGenerator(
		name="mySequence01", // 시퀀스의 고유한 이름
		sequenceName="JpaMember3_seq", // DB에서의 시퀀스 이름
		initialValue=1, // 시퀀스 초기값
		allocationSize=1 // 시퀀스 증가값
	)
	@GeneratedValue(generator="mySequence01")
	private Long id;
	
	// 필드를 통해서 데이터 접근(기본값)
	@Access(AccessType.FIELD)
	private String username;
	
	// get / set 메소드를 통해 데이터 접근
	@Access(AccessType.PROPERTY)
	@Getter
	@Setter
	private String password;
	
	// 영속 대상에서 제외(DB에 존재 x)
	@Transient 
	private String addr;
	transient private String addr2;
	
	
	// 생성자
	public Member3() { }

	public Member3(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}
