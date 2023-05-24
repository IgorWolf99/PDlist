package com.igorwolf.pdlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorwolf.pdlist.entities.Product;
import com.igorwolf.pdlist.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	public List<Product> findAll(){
		var result = productRepository.findAll();
		return result;
	}

}
