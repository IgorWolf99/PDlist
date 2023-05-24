package com.igorwolf.pdlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
