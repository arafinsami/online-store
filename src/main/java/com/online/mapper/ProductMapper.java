package com.online.mapper;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.online.entity.Product;
import com.online.model.ProductCategory;
import com.online.model.ProductCondition;
import com.online.model.ProductModel;
import com.online.model.ProductStatus;


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
	
	public List<Product> to() {
		Product product1 = Product.builder()
				.name("A1")
				.image("image one")
				.productCategory(ProductCategory.SOFTWARE)
				.productCondition(ProductCondition.NEW)
				.productStatus(ProductStatus.ACTIVE)
				.description("Intel")
				.price(102)
				.unitInStock(10)
				.manufacturer("Westarn Digital")
				.build();
		
		Product product2 = Product.builder()
				.name("A2")
				.image("image one")
				.productCategory(ProductCategory.HARDWARE)
				.productCondition(ProductCondition.NEW)
				.productStatus(ProductStatus.ACTIVE)
				.description("description two")
				.price(200)
				.unitInStock(15)
				.manufacturer("Westarn Digital")
				.build();
		List<Product> products = Arrays.asList(product1, product2);
		return products;
	}
}
