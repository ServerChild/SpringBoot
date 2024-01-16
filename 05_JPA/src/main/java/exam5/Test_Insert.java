package exam5;

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
		
		
		try {
			em.getTransaction().begin();
			
			Member5 user;
			user = new Member5("test1@test.com", "이순신", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test2@test.com", "김아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test3@test.com", "박아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test4@test.com", "이아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test5@test.com", "홍아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test6@test.com", "감아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test7@test.com", "방아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test8@test.com", "호아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test9@test.com", "하아무개", LocalDate.now());
			em.persist(user);
			
			user = new Member5("test10@test.com", "부아무개", LocalDate.now());
			em.persist(user);
			
			em.getTransaction().commit();
			System.out.println("여러명 가입 Ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
