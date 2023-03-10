package com.online.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.online.model.ProductCategory;
import com.online.model.ProductCondition;
import com.online.model.ProductStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String image;

	@Column(length = 12)
	@Enumerated(EnumType.STRING)
	private ProductCategory productCategory;

	@Column(length = 12)
	@Enumerated(EnumType.STRING)
	private ProductCondition productCondition;

	@Column(length = 12)
	@Enumerated(EnumType.STRING)
	private ProductStatus productStatus;

	private String description;

	private BigDecimal price;

	private int unitInStock;

	private String manufacturer;
}
