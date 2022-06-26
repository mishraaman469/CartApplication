package com.mindtree.cartapplication.product.exception.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {

	private int httpStatus;

	private Date date;

	private String message;

}
