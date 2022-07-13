package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;

public interface ProductsBusinessInterface
{
	//Print test
	public void test();
	
	//Grab CRUD operations
	public ProductModel getByProductId(long id);
	public List<ProductModel> getAllProducts();
	public List<ProductModel> searchProductByName(String searchTerm);
	public List<ProductModel> searchProductByLocation(String searchTerm);
	public long addProduct(ProductModel model);
	public boolean deleteProduct(long id);
	public ProductModel updateProduct(long id, ProductModel updateProduct);
	
	//Lifecycles
	public void init();
	public void destroy();
}
