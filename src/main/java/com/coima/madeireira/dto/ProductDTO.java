package com.coima.madeireira.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.coima.madeireira.entities.Category;
import com.coima.madeireira.entities.Product;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@NotBlank(message = "Campo obrigatório")
	private String description;
	
	@Positive(message = "Preço deve ser um valor positivo")
	private Double price;
	
	@PastOrPresent(message = "Data do produto não pode ser futura")
	private Instant date;
	
	private List<CategoryDTO> categorias = new ArrayList<>();
	
	public ProductDTO() {
	}
	
	public ProductDTO(Long id, String name, String description, Double price, Instant date) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.date = date;
	}

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.date = entity.getDate();
	}
	
	public ProductDTO(Product entity, Set<Category> categorias) {
		this(entity);
		categorias.forEach(cat -> this.categorias.add(new CategoryDTO(cat)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPriceBuy(Double price) {
		this.price = price;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public List<CategoryDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoryDTO> categorias) {
		this.categorias = categorias;
	}
}
