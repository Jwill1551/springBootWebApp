package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsMapper implements RowMapper<ProductModel>
{
	@Override
	public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		ProductModel product = new ProductModel(rs.getLong("vacationId"), rs.getString("vacationName"),
				rs.getString("vacationStartDate"), rs.getInt("vacationTripLength"), rs.getString("vacationPhoto"),
				rs.getString("vacationLocation"), rs.getString("vacationDescription"), rs.getDouble("vacationCost"));
		return product;
	}
}
