package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * from product p where p.price between ?1 and ?2", nativeQuery = true)
	public List<Product> getProductsUnderPrice(@Param("min") int min, @Param("max") int max);

}
