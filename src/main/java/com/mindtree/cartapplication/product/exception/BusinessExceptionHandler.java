package com.mindtree.cartapplication.product.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.cartapplication.product.exception.entity.ApiError;


@RestControllerAdvice
public class BusinessExceptionHandler {
	
	@ExceptionHandler(BussinessException.class)
	private ResponseEntity<ApiError> getHandleBusinessException(BussinessException bussinessException ){
		ApiError error=new ApiError(404,new Date(),bussinessException.getMessage());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<ApiError> getHandleBusinessException(Exception exception ){
		ApiError error=new ApiError(404,new Date(),exception.getMessage());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
	}	
	
}
