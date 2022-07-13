package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gcu.model.ProductEntity;
import com.gcu.model.ProductModel;
import com.gcu.model.ProductsMapper;

@Service
public class ProductsDataServiceForRepository implements ProductsDataAccessInterface<ProductEntity>
{
	@Autowired
	private ProductsRepository prodRepository;
	@SuppressWarnings("unused")
	//
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public ProductsDataServiceForRepository(ProductsRepository prodRepository, DataSource dataSource,
			JdbcTemplate jdbcTemplateObject)
	{
		this.prodRepository = prodRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ProductEntity> getAllProducts()
	{
		List<ProductEntity> products = (List<ProductEntity>) prodRepository.findAll(); 
		return products;
	}

	@Override
	public ProductEntity getByProductId(long id)
	{
		return prodRepository.findById(id).orElse(null);
	}

	@Override
	public List<ProductEntity> searchProductByName(String searchTerm)
	{
		List<ProductEntity> product = prodRepository.findByVacationNameContainingIgnoreCase(searchTerm);
		return product;
	}

	@Override
	public List<ProductEntity> searchProductByLocation(String searchTerm)
	{
		List<ProductEntity> product = prodRepository.findByLocationContainingIgnoreCase(searchTerm);
		return product;
	}

	@Override
	public long addProduct(ProductEntity model)
	{
		ProductEntity result = prodRepository.save(model);
		if(result == null)
		{
			return 0;
		}
		return result.getVacationId();
	}

	@Override
	public boolean deleteProduct(long id)
	{
		prodRepository.deleteById(id);
		return true;
	}

	@Override
	public ProductEntity updateProduct(long id, ProductEntity updateProduct)
	{
		ProductEntity product = prodRepository.save(updateProduct);
		return product;
	}

}
