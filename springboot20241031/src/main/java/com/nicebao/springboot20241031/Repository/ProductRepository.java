package com.nicebao.springboot20241031.Repository;

import com.nicebao.springboot20241031.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @name: ProductRepository
 * @author: IhaveBB
 * @date: 2024-10-21 22:59
 **/
public interface ProductRepository extends JpaRepository<Product, Long> {}
