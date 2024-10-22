package com.nicebao.springboot20241031.controller;

import com.nicebao.springboot20241031.model.Cart;
import com.nicebao.springboot20241031.model.CartItem;
import com.nicebao.springboot20241031.model.Order;
import com.nicebao.springboot20241031.model.Product;
import com.nicebao.springboot20241031.service.CartService;
import com.nicebao.springboot20241031.service.OrderService;
import com.nicebao.springboot20241031.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @name: ShoppingController
 * @author: IhaveBB
 * @date: 2024-10-21 22:54
 **/
@RestController
@CrossOrigin(origins = "*") // 允许所有源请求，或者指定你的前端地址
@RequestMapping("/api")
public class ShoppingController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@GetMapping("/products")
	public List<Product> getProducts() {
		// 这里需要调用相应的服务来获取商品列表
		return productService.getProductList();
	}
	@PostMapping("/cart/create/{userId}")
	public Cart createCart(@PathVariable Long userId) {
		return cartService.createCart(userId);
	}

	@PostMapping("/cart/{cartId}/add")
	public Cart addToCart(@PathVariable Long cartId, @RequestBody CartItem item) {
		return cartService.addItem(cartId, item);
	}

	@DeleteMapping("/cart/{cartId}/remove/{itemId}")
	public Cart removeFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
		return cartService.removeItem(cartId, itemId);
	}

	@GetMapping("/cart/{cartId}/items")
	public List<CartItem> getCartItems(@PathVariable Long cartId) {
		return cartService.getCartItems(cartId);
	}

	@PostMapping("/order/create")
	public Order createOrder(@RequestBody Cart cart) {
		return orderService.createOrder(cart);
	}

	@DeleteMapping("/cart/{cartId}/clear")
	public void clearCart(@PathVariable Long cartId) {
		cartService.clearCart(cartId);
	}
}
