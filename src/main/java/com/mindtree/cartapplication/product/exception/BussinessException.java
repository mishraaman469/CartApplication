package com.mindtree.cartapplication.product.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BussinessException extends RuntimeException {

	private String message;

}
