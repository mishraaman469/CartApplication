package com.mindtree.cartapplication.product.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Cart {

	private int cartId;

	private int id;

	private List<CartProduct> cartProduct;

}
