package com.example.ProductService.Services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ProductService.DTO.GetProductDetailRTO;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private RestTemplate restTemplate;

	public ProductService(ProductRepository pr, RestTemplate rtb) {
		this.productRepository = pr;
		this.restTemplate = rtb;
	}

	public Product getProductDetail(Long pId, String email, String Password) {
		if (!Authenticate(email, Password))
			return null;
		Optional<Product> product = this.productRepository.findById(pId);
		if (product.isEmpty())
			return null;
		return product.get();
	}

	public Product createProduct(Product product, String email, String password) {
		if (!Authenticate(email, password))
			return null;
		Product product_ans = this.productRepository.save(product);
		return product_ans;
	}

	public boolean Authenticate(String email, String password) {
		GetProductDetailRTO dto = new GetProductDetailRTO();

		dto.setEmail(email);
		dto.setPassword(password);
		ResponseEntity<Boolean> res = restTemplate.postForEntity("http://userService/user/verifyUser", dto,
				Boolean.class);
		boolean ans = res.getBody();
		return ans;

	}
}
