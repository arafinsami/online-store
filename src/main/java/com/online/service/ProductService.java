package com.online.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.entity.Product;
import com.online.exception.ResourceNotFoundException;
import com.online.mapper.ProductMapper;
import com.online.model.ProductModel;
import com.online.query.ProductQuery;
import com.online.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	private final ProductMapper productMapper;
	
	private final ProductQuery productQuery;

	private final EntityManager em;

	@Transactional
	public Product save(ProductModel productModel) {
		Product product = productMapper.to(productModel);
		Product p = productRepository.save(product);
		return p;
	}
	
	@Transactional
	public List<Product> saveAll() {
		return productRepository.saveAll(productMapper.to());
	}

	@Transactional
	public Product update(ProductModel productModel) {
		Product product = productMapper.from(productModel);
		Product p = productRepository.save(product);
		return p;
	}

	@Transactional(readOnly = true)
	public Product findById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
		return product;
	}

	@Transactional(readOnly = true)
	public List<ProductModel> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductModel> cq = cb.createQuery(ProductModel.class);
		Root<Product> root = cq.from(Product.class);
		productQuery.getProducts(cb, cq, root);
		TypedQuery<ProductModel> tq = em.createQuery(cq);
		List<ProductModel> products = tq.getResultList();
		return products;
	}

	@Transactional
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
}
