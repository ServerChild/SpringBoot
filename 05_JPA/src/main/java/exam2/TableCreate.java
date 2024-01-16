package exam2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TableCreate {
	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager entityManager = emf.createEntityManager();
		
		// DB랑 연동해주는 transaction을 얻어옴
		EntityTransaction transaction = entityManager.getTransaction();
		
		entityManager.close();
		
		emf.close();
	}
}
