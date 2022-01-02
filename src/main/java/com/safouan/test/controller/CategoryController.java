package com.safouan.test.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.safouan.test.model.Category;
import com.safouan.test.model.Products;
import com.safouan.test.repository.CategoryRepository;







@RestController
@RequestMapping("/api/category/")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	ProductsContorller productController = new ProductsContorller();
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/create")
	public Category createCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	//delete category
	
	/*@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("delete/{nameCategory}")
	public ResponseEntity<Map<String, Boolean>> deleteCategory (@PathVariable String nameCategory){
		Map<String, Boolean> response = new HashMap<>();
		ResponseEntity<List<Products>> prdct =productController.findByNameCat(nameCategory);
		Category category = categoryRepository.findByNameCategory(nameCategory);
		if(prdct.toString().length()>0) {
			response.put("Category contain many products", Boolean.FALSE);
		}
		else {
			categoryRepository.delete(category);
			response.put("Category Deleted", Boolean.TRUE);
		}
		return ResponseEntity.ok(response);
				
	}*/
	
	
	
	
	
	//get category of product
	/*@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("get/{nameCategory}")
	public ResponseEntity<List<Products>> getproductsCateogyr(@PathVariable String nameCategory){
		 return productController.findByNameCat(nameCategory);
	}*/
	
	

}
