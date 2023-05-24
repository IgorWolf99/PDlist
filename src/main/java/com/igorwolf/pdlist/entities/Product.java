package com.igorwolf.pdlist.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
	
	private static long serialVersionID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(nullable = false, unique = true, length = 30)
	private String nome;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false)
	private Double	valor;
	@Column(nullable= false, columnDefinition = "TEXT")
	private String descricao;
	
	
	public Product() {}
	
	public Product(Long id, String nome, Integer quantidade, Double valor) {
		Id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}


	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
