package com.mindtree.cartapplication.product.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.mindtree.cartapplication.product.model.ApparalSearch;
import com.mindtree.cartapplication.product.model.BookSearch;
import com.mindtree.cartapplication.product.repository.entity.Apparal;
import com.mindtree.cartapplication.product.repository.entity.Apparal_;
import com.mindtree.cartapplication.product.repository.entity.Book;
import com.mindtree.cartapplication.product.repository.entity.Book_;

@Component
public class ProductSpecification {

	public Specification<Book> bookSearch(BookSearch bookSearch) {

		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (bookSearch.getAuthor() != null) {
				predicates.add(criteriaBuilder.equal(root.get(Book_.AUTHOR), bookSearch.getAuthor()));
			}
			if (bookSearch.getGenre() != null) {
				predicates.add(criteriaBuilder.equal(root.get(Book_.GENRE), bookSearch.getGenre()));
			}
			if (bookSearch.getPublications() != null) {
				predicates.add(criteriaBuilder.equal(root.get(Book_.PUBLICATIONS), bookSearch.getPublications()));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

	public Specification<Apparal> apparalSearch(ApparalSearch apparalSearch) {

		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (apparalSearch.getBrand() != null) {
				predicates.add(criteriaBuilder.equal(root.get(Apparal_.BRAND), apparalSearch.getBrand()));
			}
			if (apparalSearch.getDesign() != null) {
				predicates.add(criteriaBuilder.equal(root.get(Apparal_.DESIGN), apparalSearch.getDesign()));
			}
			if (apparalSearch.getType() != null) {
				predicates.add(criteriaBuilder.equal(root.get(Apparal_.TYPE), apparalSearch.getType()));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
