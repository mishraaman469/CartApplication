package com.mindtree.cartapplication.cart.service;

import com.mindtree.cartapplication.product.model.Cart;
import com.mindtree.cartapplication.product.model.CartRequest;

public interface CartService {

	Cart getCart(int userId);

	Cart addProductToCart(CartRequest cartRequest);

	void removeProduct(CartRequest cartRequest);

}
