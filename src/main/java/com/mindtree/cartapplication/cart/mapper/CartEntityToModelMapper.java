package com.mindtree.cartapplication.cart.mapper;

import org.mapstruct.Mapper;

import com.mindtree.cartapplication.product.repository.entity.Cart;

@Mapper(componentModel = "spring")
public interface CartEntityToModelMapper {

	
	com.mindtree.cartapplication.product.model.Cart mapToCart(Cart cart);


	Cart mapToCartModel(com.mindtree.cartapplication.product.model.Cart cartProductView);

}
