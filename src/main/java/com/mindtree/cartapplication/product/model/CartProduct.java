package com.mindtree.cartapplication.product.model;

import lombok.Data;

@Data
public class CartProduct {
	private int cartProductId;

	private int cartId;

	private Product product;

	private int quantity;
}
