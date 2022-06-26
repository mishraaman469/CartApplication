package com.mindtree.cartapplication.product.repository.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "product_id")
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {

	private String genre;

	private String author;

	private String publications;
}
