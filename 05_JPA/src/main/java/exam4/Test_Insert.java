package exam4;

import java.time.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test_Insert {
	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager em = emf.createEntityManager();
		
		// EntityTransaction transaction = em.getTransaction();
		
		
		try {
			em.getTransaction().begin();
			
			Member4 user = new Member4("test@test.com", "홍길동", LocalDate.now());
			System.out.println("╭(๑¯д¯๑)╮");
			
			em.persist(user);
			System.out.println("ദ്ദി´-ω-`)");
			
			em.getTransaction().commit();
			System.out.println("DB에 SQL문 처리");
			System.out.println("가입 Ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
