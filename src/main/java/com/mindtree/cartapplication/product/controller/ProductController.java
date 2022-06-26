package com.mindtree.cartapplication.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.cartapplication.product.constant.APIConstant;
import com.mindtree.cartapplication.product.model.Apparal;
import com.mindtree.cartapplication.product.model.ApparalSearch;
import com.mindtree.cartapplication.product.model.Book;
import com.mindtree.cartapplication.product.model.BookSearch;
import com.mindtree.cartapplication.product.service.ProductService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(APIConstant.PRODUCT_DETAILS)
public class ProductController {

	@NonNull
	private ProductService productService;

	@GetMapping(APIConstant.GET_PRODUCT_BY_ID)
	public <T> ResponseEntity<T> getProductById(int productId) {
		T product = this.productService.getProductById(productId);
		return new ResponseEntity<T>(product, HttpStatus.OK);
	}

	@GetMapping(APIConstant.GET_PRODUCT_BY_NAME)
	public <T> ResponseEntity<T> getProductByName(String productName) {
		T product = this.productService.getProductByName(productName);
		return new ResponseEntity<T>(product, HttpStatus.OK);
	}

	@PostMapping(APIConstant.BOOK_SEARCH_BY_CATEGORY)
	public ResponseEntity<List<Book>> searchProduct(@RequestBody() BookSearch bookSearch) {
		List<Book> books = this.productService.searchBook(bookSearch);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@PostMapping(APIConstant.APPARAL_SEARCH_BY_CATEGORY)
	public ResponseEntity<List<Apparal>> searchProduct(@RequestBody() ApparalSearch apparalSearch) {
		List<Apparal> apparals = this.productService.searchApparal(apparalSearch);
		return new ResponseEntity<List<Apparal>>(apparals, HttpStatus.OK);
	}

}
