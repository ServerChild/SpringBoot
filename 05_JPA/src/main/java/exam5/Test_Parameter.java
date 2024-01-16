package exam5;

import java.util.*;

import jakarta.persistence.*;

public class Test_Parameter {

	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager em = emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Member5> query = em.createQuery(
					"SELECT m FROM Member5 m"
						+ " WHERE m.name = :name"
						+ " ORDER BY m.name"
						, Member5.class)
							.setParameter("name", "이순신"); // (키, 값)
			
			List<Member5> result = query.getResultList();
			
			em.getTransaction().commit();
			
			if(result.isEmpty()) {
				System.out.println("테이블이 비어있음");
			} else {
				result.forEach(user ->
						System.out.printf("| %s | %s | %tY-%<tm-%<td | \n"
								, user.getEmail(), user.getName(), user.getCreateDate()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}

}
