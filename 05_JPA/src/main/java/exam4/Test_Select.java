package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test_Select {
	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager em = emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			
			/*
			검색 시 find() 메소드 사용
				- 지정하지 않을 시 @Id가 붙은 primary key를 이용해 검색
			*/
			Member4 user = em.find(Member4.class, "test@test.com");
			
			System.out.println(user);
			
			if(user != null) {
				System.out.println("이름 : " + user.getName());
				/*
				 	't' 또는 'T' : 날짜, 시간(날짜 및 시간 서식문자 앞에 지정)
				 		ex) %tH %tM, %tS ...
				 	'Y' : 년(4자리)
				 	'y' : 년(2자리)
				 	'm' : 월(01 ~ 12)
				 	'd' : 일(01 ~ 31)
				 	'e' : 일(1 ~ 31)
				 	'H' : 24시간 형식의 시(00 ~ 23)
				 	'I' : 12시간 형식의 시(01 ~ 12)
				 	'M' : 분(00 ~ 60)
				 	'S' : 초(00 ~ 60)
				 	
				 	%< 상대 인덱스를 지정해 직전의 인수와 같은 인덱스 사용
				*/
				System.out.printf("생성 날짜 : %ty-%<tm-%<td \n", user.getCreateDate());
			} else {
				System.out.println("존재하지 않음");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
