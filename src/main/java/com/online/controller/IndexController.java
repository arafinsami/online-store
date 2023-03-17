package com.online.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.online.model.ProductModel;
import com.online.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final ProductService productService;
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Hello Online Store!");
		return "index";
	}

	@GetMapping("/products")
	public String findAll(Model model) {
		List<ProductModel> products = productService.findAll();
		model.addAttribute("products", products);
		logger.info("This is logger info{}", products);
		logger.debug("This is logger debug{}", products);
		logger.error("This is logger error");
		return "products";
	}
}
