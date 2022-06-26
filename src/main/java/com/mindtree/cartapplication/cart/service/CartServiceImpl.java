package com.mindtree.cartapplication.cart.service;

import org.springframework.stereotype.Service;

import com.mindtree.cartapplication.cart.repository.CartRepository;
import com.mindtree.cartapplication.product.exception.BussinessException;
import com.mindtree.cartapplication.product.model.Cart;
import com.mindtree.cartapplication.product.model.CartRequest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

	@NonNull
	private CartRepository cartRepository;

	@Override
	public Cart getCart(int userId) {
		return this.cartRepository.getCart(userId).orElseThrow(() -> {
			log.error("Cart not found for user id" + userId);
			throw new BussinessException("Cart not found for user id" + userId);
		});
	}

	@Override
	public Cart addProductToCart(CartRequest cartRequest) {
		return this.cartRepository.addProductToCart(cartRequest).orElseThrow(() -> {
			log.error("Cart not found for user id" + cartRequest.getUser().getUserId());
			throw new BussinessException("Cart not found for user id" + cartRequest.getUser().getUserId());
		});

	}

	@Override
	public void removeProduct(CartRequest cartRequest) {
		this.cartRepository.removeProduct(cartRequest);

	}

}
