package com.mindtree.cartapplication.cart.repository;

import java.util.Optional;

import com.mindtree.cartapplication.product.model.Cart;
import com.mindtree.cartapplication.product.model.CartRequest;

public interface CartRepository {

	Optional<Cart> getCart(int userId);

	Optional<Cart> addProductToCart(CartRequest cartRequest);

	void removeProduct(CartRequest cartRequest);

}
