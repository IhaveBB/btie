package com.nicebao.springboot20241031.service;

import com.nicebao.springboot20241031.Repository.Store;
import com.nicebao.springboot20241031.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @name: productService
 * @author: IhaveBB
 * @date: 2024-10-22 17:37
 **/
@Service
public class ProductService {
	public List<Product> getProductList() {
		return Store.getProducts().values().stream().collect(Collectors.toList());
	}
}
