package com.igorwolf.pdlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorwolf.pdlist.entities.Category;
import com.igorwolf.pdlist.entities.Product;
import com.igorwolf.pdlist.services.CategoryService;
import com.igorwolf.pdlist.services.ProductService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
	@Autowired
	public ProductService productService; 
	
	
	@GetMapping
	public List<Category> FindAllCategory(){
		return categoryService.findAll();
	}
	
	@GetMapping(value = "/{id}/products")
	public List<Product> findByList(@PathVariable Long id){
		return productService.findByList(id);
	}
}
