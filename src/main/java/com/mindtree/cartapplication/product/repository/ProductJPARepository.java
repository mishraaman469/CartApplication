package com.mindtree.cartapplication.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mindtree.cartapplication.product.repository.entity.Product;

public interface ProductJPARepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

	Optional<Product> findByProductName(String productName);

}
