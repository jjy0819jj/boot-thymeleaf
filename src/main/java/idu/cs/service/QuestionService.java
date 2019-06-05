package idu.cs.service;

import java.util.List;

import idu.cs.domain.Question;

public interface QuestionService {
	Question getUser(long id); // primary key에 해당하는 id로  조회
	Question getUserByUserId(String userId); // unique key에 해당하는 userId로 조회
	List<Question> getUsers(); // 모든 사용자 조회
	List<Question> getUsersByName(String name); // name으로 조회
	List<Question> getUsersByCompany(String company); // company으로 조회
	List<Question> getUsersByPage(int index, int size); // 페이지로 조회
	void saveUser(Question user); // 생성
	void updateUser(Question user); // 수정
	void deleteUser(long id); // 삭제
	Question getUserById(long id);
}