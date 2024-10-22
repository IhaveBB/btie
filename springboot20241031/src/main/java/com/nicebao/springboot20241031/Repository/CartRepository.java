package com.nicebao.springboot20241031.Repository;

import com.nicebao.springboot20241031.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @name: CartRepository
 * @author: IhaveBB
 * @date: 2024-10-21 22:59
 **/
public interface CartRepository extends JpaRepository<Cart, Long> {}