package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductsDataServiceForRepository;
import com.gcu.data.UsersDataAccessInterface;
import com.gcu.data.UsersDataServiceForRepository;
import com.gcu.model.LoginModel;
import com.gcu.model.ProductEntity;
import com.gcu.model.ProductModel;
import com.gcu.model.UserEntity;
import com.gcu.model.UserModel;

public class ProductsBusinessService implements ProductsBusinessInterface
{
	@Autowired
	ProductsDataServiceForRepository service;

	@Override
	public ProductModel getByProductId(long id)
	{
		ProductEntity entity = service.getByProductId(id);
		ProductModel product = new ProductModel(entity.getVacationId(), entity.getVacationName(), entity.getStartDate(),
				entity.getTripLength(), entity.getPhoto(), entity.getLocation(), entity.getDescription(), entity.getCost());
		return product;
	}

	
	@Override
	public List<ProductModel> getAllProducts()
	{
		//Users entity list
		List<ProductEntity> productsE = service.getAllProducts();
		//Translate to user model list
		List<ProductModel> products = new ArrayList<ProductModel>();
		for(ProductEntity entity: productsE)
		{
			products.add(new ProductModel(entity.getVacationId(), entity.getVacationName(), entity.getStartDate(),
				entity.getTripLength(), entity.getPhoto(), entity.getLocation(), entity.getDescription(), entity.getCost()));
		}
		return products;
	}

	@Override
	public List<ProductModel> searchProductByName(String searchTerm)
	{
		//Users entity list
		List<ProductEntity> productsE = service.searchProductByName(searchTerm);
		//Translate to user model list
		List<ProductModel> products = new ArrayList<ProductModel>();
		for(ProductEntity entity: productsE)
		{
			products.add(new ProductModel(entity.getVacationId(), entity.getVacationName(), entity.getStartDate(),
				entity.getTripLength(), entity.getPhoto(), entity.getLocation(), entity.getDescription(), entity.getCost()));
		}
		return products;
	}

	@Override
	public List<ProductModel> searchProductByLocation(String searchTerm)
	{
		//Users entity list
		List<ProductEntity> productsE = service.searchProductByLocation(searchTerm);
		//Translate to user model list
		List<ProductModel> products = new ArrayList<ProductModel>();
		for(ProductEntity entity: productsE)
		{
			products.add(new ProductModel(entity.getVacationId(), entity.getVacationName(), entity.getStartDate(),
				entity.getTripLength(), entity.getPhoto(), entity.getLocation(), entity.getDescription(), entity.getCost()));
		}
		return products;
	}
	
	@Override
	public long addProduct(ProductModel model)
	{
		ProductEntity entity = new ProductEntity(model.getVacationId(), model.getVacationName(), model.getStartDate(),
				model.getTripLength(), model.getPhoto(), model.getLocation(), model.getDescription(), model.getCost());
		return service.addProduct(entity);
	}

	@Override
	public boolean deleteProduct(long id)
	{
		return service.deleteProduct(id);
	}

	@Override
	public ProductModel updateProduct(long id, ProductModel updateProduct)
	{
		ProductEntity entity = new ProductEntity(updateProduct.getVacationId(), updateProduct.getVacationName(), updateProduct.getStartDate(),
				updateProduct.getTripLength(), updateProduct.getPhoto(), updateProduct.getLocation(), updateProduct.getDescription(), updateProduct.getCost());
		
		ProductEntity result = service.updateProduct(id, entity);
		
		ProductModel updated = new ProductModel(result.getVacationId(), result.getVacationName(), result.getStartDate(),
				result.getTripLength(), result.getPhoto(), result.getLocation(), result.getDescription(), result.getCost());
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


	@Override
	public void test()
	{
		// TODO Auto-generated method stub
		
	}
}
