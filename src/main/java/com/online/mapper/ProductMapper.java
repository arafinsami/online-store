package com.online.mapper;

import org.springframework.stereotype.Component;

import com.online.entity.Product;
import com.online.model.ProductModel;

@Component
public class ProductMapper {

	public Product to(ProductModel model) {
		Product product = Product.builder()
				.name(model.getName())
				.productCategory(model.getProductCategory())
				.productCondition(model.getProductCondition())
				.productStatus(model.getProductStatus())
				.description(model.getDescription())
				.price(model.getPrice())
				.unitInStock(model.getUnitInStock())
				.build();
		return product;
	}
	
	public Product from(ProductModel model) {
		Product product = Product.builder()
				.id(model.getId())
				.name(model.getName())
				.productCategory(model.getProductCategory())
				.productCondition(model.getProductCondition())
				.productStatus(model.getProductStatus())
				.description(model.getDescription())
				.price(model.getPrice())
				.unitInStock(model.getUnitInStock())
				.build();
		return product;
	}
}
