package exam5;

import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test_TypedQuery {

	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager em = emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			
			/*
			 	TypedQuery 클래스 : SQL문을 직접 작성하고자 할 때(영속성에 없는 SQL문 작성)
			 		- 일반 SQL문이 아닌 영속성 객체에 넣을 구문의 JPA 문법
			 			+ SELECT * -> 사용 x(테이블에 별칭을 넣어서 사용)
			*/
			// 기존 쿼리문 : SELECT * FROM MEMBER5 ORDER BY NAME
			TypedQuery<Member5> query = em.createQuery("SELECT m FROM Member5 m ORDER BY m.name", Member5.class);
			
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
