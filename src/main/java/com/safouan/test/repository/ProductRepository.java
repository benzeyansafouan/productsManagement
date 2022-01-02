package com.safouan.test.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.safouan.test.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, String>{
	List<Products> findByNameCategory (String nameCategory);

}
