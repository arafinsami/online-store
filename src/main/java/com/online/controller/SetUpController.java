package com.online.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "setup")
public class SetUpController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<String> save() {
		productService.saveAll();
		return new ResponseEntity<>("DONE", HttpStatus.CREATED);
	}

}
