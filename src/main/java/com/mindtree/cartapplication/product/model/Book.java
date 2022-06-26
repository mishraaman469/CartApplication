package com.mindtree.cartapplication.product.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Book extends Product{

	private String genre;

	private String author;

	private String publications;
	
}
