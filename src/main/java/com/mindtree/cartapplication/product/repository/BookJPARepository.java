package com.mindtree.cartapplication.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mindtree.cartapplication.product.repository.entity.Book;

public interface BookJPARepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

}
