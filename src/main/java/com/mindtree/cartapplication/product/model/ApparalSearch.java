package com.mindtree.cartapplication.product.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApparalSearch {
	private int productId;

	private String type;

	private String brand;

	private String design;

}
