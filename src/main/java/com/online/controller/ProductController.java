package com.online.controller;

import static com.online.utils.Constants.MESSAGE_KEY_SUCCESS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.online.model.ProductModel;
import com.online.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "admin")
@SessionAttributes(names = { ProductController.COMMAND_NAME })
public class ProductController {

	private final ProductService productService;

	public static final String COMMAND_NAME = "productModel";

	@GetMapping("/add-product")
	public String save(Model model) {
		ProductModel productModel = new ProductModel();
		model.addAttribute(COMMAND_NAME, productModel);
		return "add_product";
	}

	@PostMapping("/add-product")
	public String save(@Valid @ModelAttribute(COMMAND_NAME) ProductModel productModel, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes, SessionStatus sessionStatus,
			@RequestParam("image") MultipartFile file) {

		if (bindingResult.hasErrors()) {
			model.addAttribute(COMMAND_NAME, productModel);
			return "add_product";
		}

		productService.save(productModel);
		redirectAttributes.addFlashAttribute(MESSAGE_KEY_SUCCESS, "Successfully Saved Product");
		sessionStatus.setComplete();
		return "redirect:/products";
	}
}
