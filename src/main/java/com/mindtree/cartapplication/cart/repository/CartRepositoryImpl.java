package com.mindtree.cartapplication.cart.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Iterables;
import com.mindtree.cartapplication.cart.mapper.CartEntityToModelMapper;
import com.mindtree.cartapplication.product.exception.BussinessException;
import com.mindtree.cartapplication.product.model.Cart;
import com.mindtree.cartapplication.product.model.CartRequest;
import com.mindtree.cartapplication.product.repository.entity.Product;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CartRepositoryImpl implements CartRepository {

	boolean productPresent = false;

	@NonNull
	private CartJPARepository cartJPARepository;

	@NonNull
	private CartEntityToModelMapper cartModelMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Optional<Cart> getCart(int userId) {
		return this.cartJPARepository.getCartByID(userId).map(
				(com.mindtree.cartapplication.product.repository.entity.Cart c) -> this.cartModelMapper.mapToCart(c));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Optional<Cart> addProductToCart(CartRequest cartRequest) {
		Optional<com.mindtree.cartapplication.product.repository.entity.Cart> cart = this.cartJPARepository
				.findByUserId(cartRequest.getUser().getUserId());
		com.google.common.base.Optional<com.mindtree.cartapplication.product.repository.entity.CartProduct> cartProduct = Iterables
				.tryFind(cart.get().getCartProduct(), (cartProducItem) -> cartProducItem.getProduct()
						.getProductId() == cartRequest.getProduct().getProductId());
		if (cartProduct.isPresent()) {
			cartProduct.get().setQuantity(cartProduct.get().getQuantity() + cartRequest.getQuantity());
		} else {
			com.mindtree.cartapplication.product.repository.entity.CartProduct cartProducts = new com.mindtree.cartapplication.product.repository.entity.CartProduct();
			Product product = new Product();
			product.setProductId(cartRequest.getProduct().getProductId());
			cartProducts.setProduct(product);
			cartProducts.setQuantity(cartRequest.getQuantity());
			com.mindtree.cartapplication.product.repository.entity.Cart cartId = new com.mindtree.cartapplication.product.repository.entity.Cart();
			cartId.setCartId(cart.get().getCartId());
			cartProducts.setCart(cartId);
			cart.get().getCartProduct().add(cartProducts);
		}

		this.cartJPARepository.save(cart.get());
		return cart.map(
				(com.mindtree.cartapplication.product.repository.entity.Cart c) -> this.cartModelMapper.mapToCart(c));
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public void removeProduct(CartRequest cartRequest) {
		Optional<com.mindtree.cartapplication.product.repository.entity.Cart> cart = this.cartJPARepository
				.findByUserId(cartRequest.getUser().getUserId());
		if (cart.isEmpty()) {
			throw new BussinessException("Cart not found for the give user id:-" + cartRequest.getUser().getUserId());
		}
		this.cartJPARepository.deleteById(cart.get().getCartId());
		com.google.common.base.Optional<com.mindtree.cartapplication.product.repository.entity.CartProduct> cartProduct = Iterables
				.tryFind(cart.get().getCartProduct(), (cartProducItem) -> cartProducItem.getProduct()
						.getProductId() == cartRequest.getProduct().getProductId());

		if (cartProduct.isPresent()) {
			cartProduct.get().setQuantity(cartProduct.get().getQuantity() - cartRequest.getQuantity());
		}
		if (cartProduct.get().getQuantity() <= 0) {

			cart.get().getCartProduct().remove(cartProduct.get());
		}

		this.cartJPARepository.saveAndFlush(cart.get());

	}
}
