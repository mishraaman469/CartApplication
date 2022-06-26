package com.mindtree.cartapplication.product.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Users {
	@Id
	private int id;

	private String userName;

}
