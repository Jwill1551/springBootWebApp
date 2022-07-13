package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataAccessInterface;
import com.gcu.data.UsersDataServiceForRepository;
import com.gcu.model.LoginModel;
import com.gcu.model.UserEntity;
import com.gcu.model.UserModel;

public class UsersBusinessService implements UsersBusinessInterface
{
	@Autowired
	UsersDataServiceForRepository service;
	
	@Override
	public void test()
	{
		System.out.println("Test from UsersBusinessService");
	}

	@Override
	public UserModel getById(long id)
	{
		UserEntity result = service.getById(id);
		UserModel user = new UserModel(result.getId(), result.getFirstName(), result.getLastName(),
				result.getEmail(), result.getPhoneNumber(), result.getUsername(), result.getPassword());
		return user;
	}

	@Override
	public boolean login(LoginModel model)
	{
		if(service.login(model))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<UserModel> getAllUsers()
	{
		//Users entity list
		List<UserEntity> usersE = service.getAllUsers();
		//Translate to user model list
		List<UserModel> users = new ArrayList<UserModel>();
		for(UserEntity entity: usersE)
		{
			users.add(new UserModel(entity.getId(), entity.getFirstName(), entity.getLastName(), 
					entity.getEmail(), entity.getPhoneNumber(), entity.getUsername(), entity.getPassword()));
		}
		return users;
	}

	@Override
	public List<UserModel> searchByUsername(String searchTerm)
	{
		//Users entity list
		List<UserEntity> usersE = service.searchByUsername(searchTerm);
		//Translate to user model list
		List<UserModel> users = new ArrayList<UserModel>();
		for(UserEntity entity: usersE)
		{
			users.add(new UserModel(entity.getId(), entity.getFirstName(), entity.getLastName(), 
					entity.getEmail(), entity.getPhoneNumber(), entity.getUsername(), entity.getPassword()));
		}
		return users;
	}
	
	@Override
	public List<UserModel> searchByFirstName(String searchTerm)
	{
		//Users entity list
		List<UserEntity> usersE = service.searchByFirstName(searchTerm);
		//Translate to user model list
		List<UserModel> users = new ArrayList<UserModel>();
		for(UserEntity entity: usersE)
		{
			users.add(new UserModel(entity.getId(), entity.getFirstName(), entity.getLastName(), 
					entity.getEmail(), entity.getPhoneNumber(), entity.getUsername(), entity.getPassword()));
		}
		return users;
	}

	@Override
	public List<UserModel> searchByLastName(String searchTerm)
	{
		//Users entity list
		List<UserEntity> usersE = service.searchByLastName(searchTerm);
		//Translate to user model list
		List<UserModel> users = new ArrayList<UserModel>();
		for(UserEntity entity: usersE)
		{
			users.add(new UserModel(entity.getId(), entity.getFirstName(), entity.getLastName(), 
					entity.getEmail(), entity.getPhoneNumber(), entity.getUsername(), entity.getPassword()));
		}
		return users;
	}
	
	@Override
	public long addUser(UserModel model)
	{
		UserEntity entity = new UserEntity(model.getId(), model.getFirstName(), model.getLastName(), 
				model.getEmail(), model.getPhoneNumber(), model.getUsername(), model.getPassword());
		return service.addUser(entity);
	}

	@Override
	public boolean deleteUser(long id)
	{
		return service.deleteUser(id);
	}

	@Override
	public UserModel updateUser(long id, UserModel updateUser)
	{
		UserEntity entity = new UserEntity(updateUser.getId(), updateUser.getFirstName(), updateUser.getLastName(),
				updateUser.getEmail(), updateUser.getPhoneNumber(), updateUser.getUsername(), updateUser.getPassword());
		
		UserEntity result = service.updateUser(id, entity);
		
		UserModel updated = new UserModel(result.getId(), result.getFirstName(), result.getLastName(),
				result.getEmail(), result.getPhoneNumber(), result.getUsername(), result.getPassword());
		return updated;
	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}
}
