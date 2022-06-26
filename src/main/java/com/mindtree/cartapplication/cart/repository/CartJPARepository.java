package com.mindtree.cartapplication.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.cartapplication.product.repository.entity.Cart;

public interface CartJPARepository extends JpaRepository<Cart, Integer> {

	Optional<Cart> findByUserId(int userId);

	Optional<Cart> getCartByID(int userId);

}
