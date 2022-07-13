package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.model.LoginModel;
import com.gcu.model.UserEntity;
import com.gcu.model.UserModel;
import com.gcu.model.UsersMapper;

@Service
public class UsersDataServiceForRepository implements UsersDataAccessInterface<UserEntity>
{
	@Autowired
	private UsersRepository usersRepository;
	@SuppressWarnings("unused")
	//
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public UsersDataServiceForRepository(UsersRepository usersRepository, DataSource dataSource,
			JdbcTemplate jdbcTemplateObject)
	{
		this.usersRepository = usersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<UserEntity> getAllUsers()
	{
		List<UserEntity> orders = (List<UserEntity>) usersRepository.findAll();
		return orders;
	}

	@Override
	public boolean login(LoginModel model)
	{
		UserModel result = jdbcTemplateObject.queryForObject("select * from users where username = ? AND password = ?", new UsersMapper(),
				new Object[] {model.getUsername(), model.getPassword()});
		if(result != null)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public UserEntity getById(long id)
	{
		return usersRepository.findById(id).orElse(null);
	}

	@Override
	public List<UserEntity> searchByUsername(String searchTerm)
	{
		List<UserEntity> result = usersRepository.findByUsernameContainingIgnoreCase(searchTerm);
		return result;
	}
	
	@Override
	public List<UserEntity> searchByFirstName(String searchTerm)
	{
		List<UserEntity> result = usersRepository.findByFirstNameContainingIgnoreCase(searchTerm);
		return result;
	}
	
	@Override
	public List<UserEntity> searchByLastName(String searchTerm)
	{
		List<UserEntity> result = usersRepository.findByLastNameContainingIgnoreCase(searchTerm);
		return result;
	}
	
	@Override
	public long addUser(UserEntity model)
	{
		UserEntity result = usersRepository.save(model);
		if (result == null)
		{
			return 0;
		}
		return result.getId();
	}

	@Override
	public boolean deleteUser(long id)
	{
		usersRepository.deleteById(id);
		return true;
	}

	@Override
	public UserEntity updateUser(long id, UserEntity updateOrder)
	{
		UserEntity result = usersRepository.save(updateOrder);
		return result;
	}
}