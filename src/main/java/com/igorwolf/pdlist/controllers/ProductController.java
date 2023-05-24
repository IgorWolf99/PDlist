package com.igorwolf.pdlist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorwolf.pdlist.entities.Product;
import com.igorwolf.pdlist.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	public ProductService productService;
	
	@GetMapping
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Product> findById(@PathVariable Long id) {
		return productService.findById(id);
	}
}
