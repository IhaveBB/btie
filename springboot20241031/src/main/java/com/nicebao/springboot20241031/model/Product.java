package com.nicebao.springboot20241031.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name: Product
 * @author: IhaveBB
 * @date: 2024-10-21 17:58
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long id;
	private String name;
	private Double price;
}
