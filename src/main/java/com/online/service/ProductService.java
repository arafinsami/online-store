package com.online.service;

import org.springframework.stereotype.Service;

import com.online.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
}
