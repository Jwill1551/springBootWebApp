package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.gcu.model.ProductEntity;

@Component
public interface ProductsRepository extends CrudRepository<ProductEntity, Long>
{
	List<ProductEntity> findByVacationNameContainingIgnoreCase(String searchTerm);
	List<ProductEntity> findByLocationContainingIgnoreCase(String searchTerm);
}
