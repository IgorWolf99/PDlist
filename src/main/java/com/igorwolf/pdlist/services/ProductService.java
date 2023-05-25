package com.igorwolf.pdlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}
	
	@Transactional
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@Transactional
	public void delete(Product product) {
		productRepository.delete(product);
	}

	public boolean existsNameProductIgnoringSpaces(String name) {
	    List<Product> products = productRepository.findAll();

	    for (Product product : products) {
	        String existingName = product.getNome().replaceAll("\\s+", "");
	        String newName = name.replaceAll("\\s+", "");

	        if (existingName.equalsIgnoreCase(newName)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean existsNameProduct(String nameProduct) {
		return productRepository.existsByNome(nameProduct);
	}

}
