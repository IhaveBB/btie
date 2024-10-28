package com.nicebao.springboot20241031.service;

import com.nicebao.springboot20241031.Repository.Store;
import com.nicebao.springboot20241031.model.Cart;
import com.nicebao.springboot20241031.model.CartItem;
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
		cart.setId(System.currentTimeMillis());
		cart.setUserId(userId);
		Store.getCarts().put(cart.getId(), cart);
		return cart;
	}

	public Cart addItem(Long cartId, CartItem item) {
		Cart cart = Store.getCarts().get(cartId);
		if (cart == null) {
			throw new IllegalArgumentException("购物车不能为空");
		}
		item.setId(System.currentTimeMillis());
		cart.getItems().add(item);
		return cart;
	}

	public Cart removeItem(Long cartId, Long itemId) {
		Cart cart = Store.getCarts().get(cartId);
		if (cart == null) {
			throw new IllegalArgumentException("购物车不能为空");
		}
		cart.getItems().removeIf(item -> item.getId().equals(itemId));
		return cart;
	}

	public List<CartItem> getCartItems(Long cartId) {
		Cart cart = Store.getCarts().get(cartId);
		if (cart == null) {
			throw new IllegalArgumentException("购物车Id不能为空");
		}
		return cart.getItems();
	}

	public void clearCart(Long cartId) {
		Store.getCarts().remove(cartId);
	}
}