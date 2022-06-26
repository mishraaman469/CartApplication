package com.mindtree.cartapplication.product.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Apparal extends Product {

	private String type;

	private String brand;

	private String design;

}
