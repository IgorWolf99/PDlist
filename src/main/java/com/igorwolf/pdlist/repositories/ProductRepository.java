package com.igorwolf.pdlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igorwolf.pdlist.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
