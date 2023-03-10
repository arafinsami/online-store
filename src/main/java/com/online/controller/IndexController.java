package com.online.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.online.entity.Product;
import com.online.model.ProductModel;
import com.online.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final ProductService productService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Hello Online Store!");
		return "index";
	}

	@GetMapping("/products")
	public String findAll(Model model) {
		List<ProductModel> products = productService.findAll();
		model.addAttribute("products", products);
		return "products";
	}
}
