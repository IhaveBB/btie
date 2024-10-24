package com.nicebao.springboot20241031.service;

import com.nicebao.springboot20241031.Repository.Store;
import com.nicebao.springboot20241031.model.Cart;
import com.nicebao.springboot20241031.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: OrderService
 * @author: IhaveBB
 * @date: 2024-10-21 22:53
 **/

@Service
public class OrderService {

	@Autowired
	private CartService cartService;

	public Order createOrder(Long cartId) {
		Cart cart = Store.getCarts().get(cartId);
		if (cart == null) {
			throw new IllegalArgumentException("购物车不能为空");
		}

		Order order = new Order();
		order.setId(System.currentTimeMillis());
		order.setUserId(cart.getUserId());
		order.setItems(cart.getItems());
		order.setTotalAmount(cart.getItems().stream()
				.mapToDouble(item -> item.getQuantity() * getProductPrice(item.getProductId()))
				.sum());

		Store.getOrders().put(order.getId(), order);
		cartService.clearCart(cartId);

		return order;
	}

	private double getProductPrice(Long productId) {
		return Store.getProducts().get(productId).getPrice();
	}
}