package com.igorwolf.pdlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igorwolf.pdlist.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
