package com.devsuperior.dscatalog.tests;

import java.time.Instant;

import com.coima.madeireira.dto.CategoryDTO;
import com.coima.madeireira.dto.ProductDTO;
import com.coima.madeireira.entities.Category;
import com.coima.madeireira.entities.Product;

public class Factory {

	public static Product createProduct() {
		Product product = new Product(1L, "Phone", "Good Phone", 800.0, Instant.parse("2020-10-20T03:00:00Z"));
		product.getCategories().add(createCategory());
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product, product.getCategories());
	}
	
	public static Category createCategory() {
		return new Category(1L, "Electronics");
		 
	}
	
	public static CategoryDTO createCategoryDTO() {
		Category category = createCategory();
		return new CategoryDTO(category);
	}
}
