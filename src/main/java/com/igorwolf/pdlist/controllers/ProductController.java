package com.igorwolf.pdlist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorwolf.pdlist.entities.Product;
import com.igorwolf.pdlist.services.ProductService;

import jakarta.validation.Valid;

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
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Product product) {
		if (product.getNome().trim().isEmpty() || product.getDescricao().trim().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro. Um dos campos está vazio.");
		}
		if (productService.existsNameProductIgnoringSpaces(product.getNome())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro. Produto já está cadastrado.");
	    }
		
		    Product productSave = productService.save(product);
		    String message = "Produto: " + productSave.getNome() + " adicionado com sucesso.";
		    return ResponseEntity.status(HttpStatus.OK).body(message);
		}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		Optional<Product> productOptional = productService.findById(id);
		if(!productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
		}
		productService.delete(productOptional.get());
		String message = "Produto: " +  productOptional.get().getNome() + " deletado com sucesso.";
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
}
