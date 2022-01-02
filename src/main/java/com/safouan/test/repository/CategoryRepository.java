package com.safouan.test.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safouan.test.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
	Category findByNameCategory (String nameCategory);

}
