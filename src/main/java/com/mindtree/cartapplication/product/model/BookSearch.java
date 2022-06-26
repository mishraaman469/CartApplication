package com.mindtree.cartapplication.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookSearch {
	private int productId;

	private String genre;

	private String author;

	private String publications;

}
