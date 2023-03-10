package com.online.model;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ProductModel {

	private Long id;

	private String name;
	
	private String image;

	private ProductCategory productCategory;

	private ProductCondition productCondition;

	private ProductStatus productStatus;

	private String description;

	private BigDecimal price;

	private int unitInStock;

	private String manufacturer;

	public ProductModel(Long id, String name, String image, ProductCategory productCategory,
			ProductCondition productCondition, ProductStatus productStatus, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.productCategory = productCategory;
		this.productCondition = productCondition;
		this.productStatus = productStatus;
		this.price = price;
	}
}
