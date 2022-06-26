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
public class Apparal extends Product {

	private String type;

	private String brand;

	private String design;

}
