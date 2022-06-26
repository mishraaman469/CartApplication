package com.mindtree.cartapplication.product.service;

import java.util.List;

import com.mindtree.cartapplication.product.model.Apparal;
import com.mindtree.cartapplication.product.model.ApparalSearch;
import com.mindtree.cartapplication.product.model.Book;
import com.mindtree.cartapplication.product.model.BookSearch;

public interface ProductService {

	<T> T getProductById(int productId);

	<T> T getProductByName(String productName);

	List<Book> searchBook(BookSearch bookSearch);

	List<Apparal> searchApparal(ApparalSearch apparalSearch);

}
