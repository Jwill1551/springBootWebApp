package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersMapper implements RowMapper<UserModel>
{
	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		UserModel user = new UserModel(rs.getLong("userId"), rs.getString("userFirst"),
				rs.getString("userLast"), rs.getString("userEmail"), rs.getString("userPhone"),
				rs.getString("username"), rs.getString("password"));
		return user;
	}
}
