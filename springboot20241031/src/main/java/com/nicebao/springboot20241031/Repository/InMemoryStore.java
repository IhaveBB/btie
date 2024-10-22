package com.nicebao.springboot20241031.Repository;

import com.nicebao.springboot20241031.model.Cart;
import com.nicebao.springboot20241031.model.Order;
import com.nicebao.springboot20241031.model.Product;
import com.nicebao.springboot20241031.model.User;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @name: InMemoryStore
 * @author: IhaveBB
 * @date: 2024-10-22 13:09
 **/

public class InMemoryStore {
	@Getter
	private static final Map<Long, User> users = new HashMap<>();
	@Getter
	private static final Map<Long, Product> products = new HashMap<>();
	@Getter
	private static final Map<Long, Cart> carts = new HashMap<>();
	@Getter
	private static final Map<Long, Order> orders = new HashMap<>();

	static {
		products.put(1L, new Product(1L, "商品1", 100.0));
		products.put(2L, new Product(2L, "商品2", 150.0));
	}

}
