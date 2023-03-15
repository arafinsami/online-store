package com.online.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductModel {

	private Long id;

	private String name;
	
	private String image;

	private ProductCategory productCategory;

	private ProductCondition productCondition;

	private ProductStatus productStatus;

	private String description;

	private Integer price;

	private Integer unitInStock;

	private String manufacturer;

	public ProductModel(Long id, String name, String image, ProductCategory productCategory,
			ProductCondition productCondition, ProductStatus productStatus, Integer price) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.productCategory = productCategory;
		this.productCondition = productCondition;
		this.productStatus = productStatus;
		this.price = price;
	}
}
