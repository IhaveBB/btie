package com.nicebao.springboot20241031.Repository;

import com.nicebao.springboot20241031.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @name: OrderRepository
 * @author: IhaveBB
 * @date: 2024-10-21 22:59
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {}
