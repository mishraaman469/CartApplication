package com.mindtree.cartapplication.product.model;

import lombok.Data;

@Data
public class CartRequest {

	private Users user;

	private Product product;

	private int quantity;
}
