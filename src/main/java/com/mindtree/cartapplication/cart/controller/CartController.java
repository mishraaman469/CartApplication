package com.mindtree.cartapplication.cart.controller;

import com.mindtree.cartapplication.cart.service.CartService;
import com.mindtree.cartapplication.product.constant.APIConstant;
import com.mindtree.cartapplication.product.model.Cart;
import com.mindtree.cartapplication.product.model.CartRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {

	@NonNull
	private CartService cartService;

	@GetMapping(APIConstant.VIEW_CART)
	public ResponseEntity<Cart> getCart(int userId) {
		Cart cart = this.cartService.getCart(userId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@PostMapping(APIConstant.ADD_PRODUCT_TO_CART)
	public ResponseEntity<Cart> addProductToCart(@RequestBody() CartRequest cartRequest) {
		Cart cart = this.cartService.addProductToCart(cartRequest);
		return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
	}

	@DeleteMapping(APIConstant.REMOVE_PRODUCT_TO_CART)
	public void removeProduct(@RequestBody()final CartRequest cartRequest) {
		this.cartService.removeProduct(cartRequest);
	}

}
