package com.mindtree.cartapplication.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.cartapplication.product.exception.BussinessException;
import com.mindtree.cartapplication.product.model.Apparal;
import com.mindtree.cartapplication.product.model.ApparalSearch;
import com.mindtree.cartapplication.product.model.Book;
import com.mindtree.cartapplication.product.model.BookSearch;
import com.mindtree.cartapplication.product.repository.ProductRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	@NonNull
	private ProductRepository productRepository;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProductById(int productId) {
		return (T) this.productRepository.getProductById(productId).orElseThrow(() -> {
			log.error("Product not found for the particular id:-" + productId);
			throw new BussinessException("Product not found for the particular id:-" + productId);
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProductByName(String productName) {
		return (T) this.productRepository.getProductName(productName).orElseThrow(() -> {
			log.error("Product not found for the particular id:-" + productName);
			throw new BussinessException("Product not found for the particular id:-" + productName);
		});
	}

	@Override
	public List<Book> searchBook(BookSearch bookSearch) {
		return  this.productRepository.searchBook(bookSearch).orElseThrow(() -> {
			log.error("Product not found"+bookSearch);
			throw new BussinessException("Product not found"+bookSearch);
		});
	}

	@Override
	public List<Apparal> searchApparal(ApparalSearch apparalSearch) {
		return  this.productRepository.searchApparal(apparalSearch).orElseThrow(() -> {
			log.error("Product not found"+apparalSearch);
			throw new BussinessException("Product not found"+apparalSearch);
		});
	}

}
