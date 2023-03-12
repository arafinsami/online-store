package com.online.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.online.entity.Product;
import com.online.model.ProductModel;

@Component
public class ProductQuery {

	public void getProducts(CriteriaBuilder cb, CriteriaQuery<ProductModel> cq, Root<Product> root) {
		cq.select(cb.construct(ProductModel.class, 
				        root.get("id"),
						root.get("name"),
						root.get("image"),
						root.get("productCategory"),
						root.get("productCondition"),
						root.get("productStatus"),
						root.get("price")));
	}
}
