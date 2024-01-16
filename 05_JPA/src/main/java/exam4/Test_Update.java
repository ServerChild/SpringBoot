package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test_Update {
	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager em = emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			
			 	// UPDATE를 하기 전에 해당하는 데이터를 찾은 후 해야함
				Member4 user = em.find(Member4.class, "test@test.com");
				
				if(user == null) {
					System.out.println("존재하지 않음");
					return;
				}
				
				// 자바 객체를 통해 영속 컨텍스트 값 변경
				user.changeName("이아무개");
			
			/*
				// 새로운 객체 생성 후 데이터 변경(DB에는 반영 x, 영속성에 있는 객체만 변경)
				Member4 user = new Member4();
				
				user.changeName("이아무개");
			*/
				
			em.getTransaction().commit();
			System.out.println("이름 변경 Ok");
		} catch (Exception e) {
			e.printStackTrace();
			
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
