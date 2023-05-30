package com.igorwolf.pdlist;

import com.igorwolf.pdlist.entities.Category;

public interface ProductProjection {
	
	Long getId();
	String getNome();
	Integer getQuantidade();
	Double getValor();
	String getDescricao();
	Category getCategory();

}
