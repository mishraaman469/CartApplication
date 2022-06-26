package com.mindtree.cartapplication.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.cartapplication.product.mapper.ProductEntityToProductModel;
import com.mindtree.cartapplication.product.model.Apparal;
import com.mindtree.cartapplication.product.model.ApparalSearch;
import com.mindtree.cartapplication.product.model.Book;
import com.mindtree.cartapplication.product.model.BookSearch;
import com.mindtree.cartapplication.product.specification.ProductSpecification;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

	@NonNull
	private ProductJPARepository productJpaRepository;

	@NonNull
	private BookJPARepository bookJpaRepository;

	@NonNull
	private ApparalJPARepository apparalJpaRepository;

	@NonNull
	private ProductEntityToProductModel productMapper;

	@NonNull
	private ProductSpecification productSpecification;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public <T> Optional<T> getProductById(int productId) {
		return this.productJpaRepository.findById(productId).map(
				(com.mindtree.cartapplication.product.repository.entity.Product p) -> this.productMapper.mapToModel(p));
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public <T> Optional<T> getProductName(String productName) {
		return this.productJpaRepository.findByProductName(productName).map(
				(com.mindtree.cartapplication.product.repository.entity.Product p) -> this.productMapper.mapToModel(p));
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Optional<List<Book>> searchBook(BookSearch bookSearch) {
		return Optional.ofNullable(this.bookJpaRepository.findAll(productSpecification.bookSearch(bookSearch)))
				.map(productMapper::mapToBook);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Optional<List<Apparal>> searchApparal(ApparalSearch apparalSearch) {
		return Optional.ofNullable(this.apparalJpaRepository.findAll(productSpecification.apparalSearch(apparalSearch)))
				.map(productMapper::mapToApparal);
	}

}
