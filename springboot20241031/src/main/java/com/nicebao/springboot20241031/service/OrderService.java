package com.nicebao.springboot20241031.service;

import com.nicebao.springboot20241031.Repository.InMemoryStore;
import com.nicebao.springboot20241031.Repository.OrderRepository;
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
	public Order createOrder(Cart cart) {
		Order order = new Order();
		order.setId(System.currentTimeMillis());
		order.setUserId(cart.getUserId());
		order.setItems(cart.getItems());
		order.setTotalAmount(cart.getItems().stream()
				.mapToDouble(item -> item.getQuantity() * getProductPrice(item.getProductId()))
				.sum());
		InMemoryStore.getOrders().put(order.getId(), order);
		return order;
	}

	private double getProductPrice(Long productId) {
		return InMemoryStore.getProducts().get(productId).getPrice();
	}
}

