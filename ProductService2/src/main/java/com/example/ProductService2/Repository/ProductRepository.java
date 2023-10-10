package com.example.ProductService2.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductService2.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product save(Product product);

	Optional<Product> findById(Long id);
}
