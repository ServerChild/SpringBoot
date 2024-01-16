package exam1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class BasicUse {
	public static void main(String[] args) {
		// 필수
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01");
		
		EntityManager entityManager = emf.createEntityManager();
		
		// DB랑 연동해주는 transaction을 얻어옴
		EntityTransaction transaction = entityManager.getTransaction();
		
		
		try {
			// 시작점 지정
			transaction.begin();
			
			Member1 user = new Member1("홍길동", LocalDate.now());
			
			// .persist() : 영속성으로 객체에 데이터 입력(메모리에 insert 하는 부분)
			entityManager.persist(user);
			
			// 실제 DB에 insert
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			// 오류 발생 시 rollback 해줌
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		emf.close();
	}
}
