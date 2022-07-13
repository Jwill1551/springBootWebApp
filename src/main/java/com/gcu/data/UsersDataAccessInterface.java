package com.gcu.data;

import java.util.List;

import com.gcu.model.LoginModel;
import com.gcu.model.UserModel;

public interface UsersDataAccessInterface<T>
{
	public boolean login(LoginModel model);
	public T getById(long id);
	public List<T> getAllUsers();
	public List<T> searchByUsername(String searchTerm);
	public List<T> searchByFirstName(String searchTerm);
	public List<T> searchByLastName(String searchTerm);
	public long addUser(T model);
	public boolean deleteUser(long id);
	public T updateUser(long id, T updateUser);
}
