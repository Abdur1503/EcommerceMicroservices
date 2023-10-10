package com.example.ProductService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductService.DTO.CreateProductDto;
import com.example.ProductService.DTO.GetProductDetailRTO;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Services.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService pr) {
		this.productService = pr;
	}

	@GetMapping("/products/{product_Id}")
	Product getProductDetail(@PathVariable("product_Id") Long pid, @RequestBody GetProductDetailRTO request) {
		Product product = this.productService.getProductDetail(pid, request.getEmail(), request.getPassword());
		return product;
	}

	@PostMapping("/products")
	Product createProduct(@RequestBody CreateProductDto request) {
		Product product2 = this.productService.createProduct(request.getProduct(), request.getEmail(),
				request.getPassword());
		return product2;
	}
}
