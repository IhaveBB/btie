package com.nicebao.springboot20241031.Repository;

import com.nicebao.springboot20241031.model.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @name: InMemoryStore
 * @author: IhaveBB
 * @date: 2024-10-22 13:09
 **/

public class Store {
	@Getter
	private static final Map<Long, User> users = new HashMap<>();
	@Getter
	private static final Map<Long, Product> products = new HashMap<>();
	@Getter
	private static final Map<Long, Cart> carts = new HashMap<>();
	@Getter
	private static final Map<Long, Order> orders = new HashMap<>();

	static {
		users.put(1L, new User(1L, "用户1", "password1"));
		users.put(2L, new User(2L, "用户2", "password2"));

		products.put(1L, new Product(1L, "商品1", 100.0));
		products.put(2L, new Product(2L, "商品2", 150.0));
		products.put(3L, new Product(3L, "商品3", 200.0));
		products.put(4L, new Product(4L, "商品4", 250.0));

		Cart cart1 = new Cart(1L, 1L, new ArrayList<>());
		Cart cart2 = new Cart(2L, 2L, new ArrayList<>());
		carts.put(cart1.getId(), cart1);
		carts.put(cart2.getId(), cart2);

		List<CartItem> orderItems1 = new ArrayList<>();
		orderItems1.add(new CartItem(1L, 1L, 2, null));
		Order order1 = new Order(1L, 1L, orderItems1, 200.0);
		orders.put(order1.getId(), order1);
	}
}
