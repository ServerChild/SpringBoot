package exam5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Member_TableCreate {
	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}
}
