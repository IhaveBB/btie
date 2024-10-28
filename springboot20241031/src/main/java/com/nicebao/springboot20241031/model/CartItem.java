package com.nicebao.springboot20241031.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name: CartItem
 * @author: IhaveBB
 * @date: 2024-10-21 22:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	private Long id;
	private Long productId;
	private Integer quantity;
	private Cart cart;
}
