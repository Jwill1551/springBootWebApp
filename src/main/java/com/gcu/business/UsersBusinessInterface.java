package com.gcu.business;

import java.util.List;

import com.gcu.model.LoginModel;
import com.gcu.model.UserModel;

public interface UsersBusinessInterface
{
	//Print test
	public void test();
	
	//Grab CRUD operations
	public UserModel getById(long id);
	public boolean login(LoginModel model);
	public List<UserModel> getAllUsers();
	public List<UserModel> searchByUsername(String searchTerm);
	public List<UserModel> searchByFirstName(String searchTerm);
	public List<UserModel> searchByLastName(String searchTerm);
	public long addUser(UserModel model);
	public boolean deleteUser(long id);
	public UserModel updateUser(long id, UserModel updateUser);
	
	//Lifecycles
	public void init();
	public void destroy();
}
