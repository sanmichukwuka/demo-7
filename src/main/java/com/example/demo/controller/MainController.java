package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

//import com.example.demo.model.Product;
//import com.example.demo.service.ProductService;

import lombok.Data;

@Data
@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all
					// controllers, for the navbar.
public class MainController {
//	@Autowired
//	ProductService productService;

	@GetMapping("/")
	public String main() {
		// fill this portion in
		return "main";
	}
	

//	@ModelAttribute("products")
//	public List<Product> products() {
//		// fill this portion in
//		return null;
//	}

	@ModelAttribute("categories")
	public List<String> categories() {
		// fill this portion in
		return null;
	}

	@ModelAttribute("brands")
	public List<String> brands() {
		// fill this portion in
		return null;
	}

	@GetMapping("/filter")
	public String filter(@RequestParam(required = false) String category, @RequestParam(required = false) String brand,
			Model model) {
//		List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
//		model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
		return "main";
	}

	@GetMapping("/about")
	public String about() {
		// fill this portion in
		return null;
	}
}
