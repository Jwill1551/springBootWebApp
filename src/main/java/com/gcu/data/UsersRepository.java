package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.gcu.model.UserEntity;

@Component
public interface UsersRepository extends CrudRepository<UserEntity, Long>
{
	List<UserEntity> findByUsernameContainingIgnoreCase(String searchTerm);
	List<UserEntity> findByFirstNameContainingIgnoreCase(String searchTerm);
	List<UserEntity> findByLastNameContainingIgnoreCase(String searchTerm);
}
