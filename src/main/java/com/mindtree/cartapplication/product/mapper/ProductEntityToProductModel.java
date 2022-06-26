package com.mindtree.cartapplication.product.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import com.mindtree.cartapplication.product.repository.entity.Apparal;
import com.mindtree.cartapplication.product.repository.entity.Book;
import com.mindtree.cartapplication.product.repository.entity.Product;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ProductEntityToProductModel {

	@SuppressWarnings("unchecked")
	default <T> T mapToModel(Product p) {
		if (p == null) {
			return null;
		}

		if (Book.class.isInstance(p)) {
			Book b = (Book) p;
			Book book = new Book();
			book.setAuthor(b.getAuthor());
			book.setGenre(b.getGenre());
			book.setPublications(b.getPublications());
			book.setProductId(b.getProductId());
			book.setProductName(b.getProductName());
			book.setPrice(b.getPrice());
			com.mindtree.cartapplication.product.model.Book bookModel = this.mapToBook(book);
			return (T) bookModel;
		} else {
			Apparal apparals = (Apparal) p;
			Apparal apparal = new Apparal();
			apparal.setType(apparals.getType());
			apparal.setBrand(apparals.getBrand());
			apparal.setDesign(apparals.getDesign());
			apparal.setProductId(apparals.getProductId());
			apparal.setProductName(apparals.getProductName());
			apparal.setPrice(apparals.getPrice());
			com.mindtree.cartapplication.product.model.Apparal apparalModel = this.mapToApparal(apparal);
			return (T) apparalModel;
		}
	}

	List<com.mindtree.cartapplication.product.model.Book> mapToBook(List<Book> book);

	com.mindtree.cartapplication.product.model.Book mapToBook(Book book);

	List<com.mindtree.cartapplication.product.model.Apparal> mapToApparal(List<Apparal> apparal);

	com.mindtree.cartapplication.product.model.Apparal mapToApparal(Apparal apparal);

}
