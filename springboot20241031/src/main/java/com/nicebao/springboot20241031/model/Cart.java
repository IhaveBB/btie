package com.nicebao.springboot20241031.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: Cart
 * @author: IhaveBB
 * @date: 2024-10-21 17:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private Long id;
	private Long userId;
	private List<CartItem> items = new ArrayList<>();
}
