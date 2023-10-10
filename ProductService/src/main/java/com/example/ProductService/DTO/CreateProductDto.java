package com.example.ProductService.DTO;

import com.example.ProductService.Model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
	private Product product;
	private String email;
	private String password;

}
