package idu.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idu.cs.entity.UserEntity;

@Repository
public interface QuestionRepository 
	extends JpaRepository<UserEntity, Long> {
	// findById , save , delete 선언없이도 구현 가능
	
	//아래 메소드들은 선언해야 JPA 규칙에 의해 구현됨
	// find - select문, By - where, OrderBy - order by, ASC, DASC 함께사용
	List<UserEntity> findByName(String name);
	//List<UserEntity> findByNameOrderByIdDESC(String name); - ID내림차순
	List<UserEntity> findByCompany(String company);
	UserEntity findByUserId(String userId);
}
