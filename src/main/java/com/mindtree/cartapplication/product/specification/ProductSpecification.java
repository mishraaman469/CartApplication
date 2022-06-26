package com.mindtree.cartapplication.product.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.mindtree.cartapplication.product.model.ApparalSearch;
import com.mindtree.cartapplication.product.model.BookSearch;
import com.mindtree.cartapplication.product.repository.entity.Apparal;
import com.mindtree.cartapplication.product.repository.entity.Book;

@Component
public class ProductSpecification {

	public Specification<Book> bookSearch(BookSearch bookSearch) {

		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (bookSearch.getAuthor() != null) {
				predicates.add(criteriaBuilder.equal(root.get("author"), bookSearch.getAuthor()));
			}
			if (bookSearch.getGenre() != null) {
				predicates.add(criteriaBuilder.equal(root.get("genre"), bookSearch.getGenre()));
			}
			if (bookSearch.getPublications() != null) {
				predicates.add(criteriaBuilder.equal(root.get("publications"), bookSearch.getPublications()));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

	public Specification<Apparal> apparalSearch(ApparalSearch apparalSearch) {

		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (apparalSearch.getBrand() != null) {
				predicates.add(criteriaBuilder.equal(root.get("brand"), apparalSearch.getBrand()));
			}
			if (apparalSearch.getDesign() != null) {
				predicates.add(criteriaBuilder.equal(root.get("design"), apparalSearch.getDesign()));
			}
			if (apparalSearch.getType() != null) {
				predicates.add(criteriaBuilder.equal(root.get("type"), apparalSearch.getType()));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
