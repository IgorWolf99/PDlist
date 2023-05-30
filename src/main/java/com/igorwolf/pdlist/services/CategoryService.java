package com.igorwolf.pdlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorwolf.pdlist.entities.Category;
import com.igorwolf.pdlist.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	public CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
		
	}
}
