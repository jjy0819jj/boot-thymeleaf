package idu.cs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idu.cs.domain.User;
import idu.cs.entity.UserEntity;
import idu.cs.repository.UserRepository;
import idu.cs.exception.ResourceNotFoundException;


@Service("userService")
public class UserServicelmpl implements UserService {

	@Autowired UserRepository repository;
	
	@Override
	public User getUser(long id) {
		// TODO Auto-generated method stub
		UserEntity userEntity = null;
		try {
			userEntity = repository.findById(id).orElseThrow(() 
					-> new ResourceNotFoundException("not found " + id ));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userEntity.buildDomain();
	}
	
	@Override
	public User getUserById(long id) {
		UserEntity entity = null;
		try {
			entity = repository.findById(id).orElseThrow(() ->
			 new ResourceNotFoundException("not found: " + id));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		User user = entity.buildDomain();
		return user;
	}
	
	@Override
	public User getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		
		//DB,
		UserEntity entity = repository.findByUserId(userId);
		User user = entity.buildDomain();
		return user;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		List<UserEntity> entities = repository.findAll();
		// Repository-Entity -> Service-Domain
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}
		return users;
	}

	@Override
	public List<User> getUsersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByPage(int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();  
		/* 도메인-User 개겣를 entity-userEntity 생성
		 DB 저장을 위해 Repository가 Entity를 필요로 함 */
		entity.buildEntity(user);
		repository.save(entity);

	}

	@Override
	public void updateUser(User user) {
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.save(entity);
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub

	}

}
