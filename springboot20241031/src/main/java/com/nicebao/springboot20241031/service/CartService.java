package com.nicebao.springboot20241031.service;

import com.nicebao.springboot20241031.Repository.CartRepository;
import com.nicebao.springboot20241031.Repository.InMemoryStore;
import com.nicebao.springboot20241031.model.Cart;
import com.nicebao.springboot20241031.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: CartService
 * @author: IhaveBB
 * @date: 2024-10-21 22:52
 **/
@Service
public class CartService {

	public Cart createCart(Long userId) {
		Cart cart = new Cart();
		cart.setId(System.currentTimeMillis()); // 生成唯一ID
		cart.setUserId(userId);
		InMemoryStore.getCarts().put(cart.getId(), cart);
		return cart;
	}

	public Cart addItem(Long cartId, CartItem item) {
		Cart cart = InMemoryStore.getCarts().get(cartId);
		if (cart == null) {
			throw new IllegalArgumentException("Cart not found");
		}
		item.setId(System.currentTimeMillis());
		item.setCart(cart);
		cart.getItems().add(item);
		return cart;
	}

	public Cart removeItem(Long cartId, Long itemId) {
		Cart cart = InMemoryStore.getCarts().get(cartId);
		cart.getItems().removeIf(item -> item.getId().equals(itemId));
		return cart;
	}

	public List<CartItem> getCartItems(Long cartId) {
		if (cartId == null) {
			throw new IllegalArgumentException("Cart ID cannot be null");
		}
		return InMemoryStore.getCarts().get(cartId).getItems();
	}

	public void clearCart(Long cartId) {
		InMemoryStore.getCarts().remove(cartId);
	}
}

