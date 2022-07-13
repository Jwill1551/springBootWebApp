package com.gcu.data;

import java.util.List;

import com.gcu.model.ProductModel;

public interface ProductsDataAccessInterface<T>
{
	public T getByProductId(long id);
	public List<T> getAllProducts();
	public List<T> searchProductByName(String searchTerm);
	public List<T> searchProductByLocation(String searchTerm);
	public long addProduct(T model);
	public boolean deleteProduct(long id);
	public T updateProduct(long id, T updateProduct);
}
