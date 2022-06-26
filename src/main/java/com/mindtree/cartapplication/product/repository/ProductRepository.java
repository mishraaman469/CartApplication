package com.mindtree.cartapplication.product.repository;

import java.util.List;
import java.util.Optional;

import com.mindtree.cartapplication.product.model.Apparal;
import com.mindtree.cartapplication.product.model.ApparalSearch;
import com.mindtree.cartapplication.product.model.Book;
import com.mindtree.cartapplication.product.model.BookSearch;

public interface ProductRepository {

	<T> Optional<T> getProductById(int productId);

	Optional<List<Book>> searchBook(BookSearch bookSearch);

	Optional<List<Apparal>> searchApparal(ApparalSearch apparalSearch);

	<T> Optional<T> getProductName(String productName);

}
