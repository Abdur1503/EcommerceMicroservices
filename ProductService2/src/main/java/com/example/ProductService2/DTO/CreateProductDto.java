package com.example.ProductService2.DTO;

import com.example.ProductService2.Model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
	private Product product;
	private String email;
	private String password;

}
