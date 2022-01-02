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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safouan.test.exception.ResourceNotFoundException;
import com.safouan.test.model.Products;
import com.safouan.test.repository.ProductRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductsContorller {
	
	@Autowired
	private ProductRepository productRepository;
	
	//get all Products
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public List<Products> getAllProducts(){
		return productRepository.findAll();
	}
	
	
	//add products
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Products createProduct(@RequestBody Products product) {
		return productRepository.save(product);
	}
	
	// get Product by ID
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{id}")
	public ResponseEntity<Products> getProductById (@PathVariable String id) {
		Products product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id:"+id));
		return ResponseEntity.ok(product);
	}
	
	
	
	
	// get product by id category
	/*@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getcat/{category}")
	public ResponseEntity<List<Products>> getProductByIdCat (@PathVariable String category) {
		List<Products> productList = productRepository.findBy_IdCat(category);
		return ResponseEntity.ok(productList);
	}*/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getbynamecat/{nameCategory}")
	public ResponseEntity<List<Products>> findByNameCat (@PathVariable String nameCategory) {
		List<Products> productList = productRepository.findByNameCategory(nameCategory);
		return ResponseEntity.ok(productList);
	}
	
	
	
	
	//update Product
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public ResponseEntity<Products> updtaeProductByID (@RequestBody Products productDetails){
		Products product = productRepository.findById(productDetails.getName_Products()).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id"));
		
		product.setName_Products(productDetails.getName_Products());
		product.setNameCategory(productDetails.getNameCategory());
		
		Products updateProct = productRepository.save(product);
		return ResponseEntity.ok(updateProct);
		
		
	}
	
	//delete Product
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("delete/{id}")
	//@RequestMapping(value = "products/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Boolean>> deleteProduct (@PathVariable String id){
	Products product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id:"+id));
	
	productRepository.delete(product);
	Map<String, Boolean> response = new HashMap<>();
	response.put("Deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	
	}
	
	
	

}
