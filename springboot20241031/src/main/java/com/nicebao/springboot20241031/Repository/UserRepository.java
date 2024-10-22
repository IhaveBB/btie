package com.nicebao.springboot20241031.Repository;

import com.nicebao.springboot20241031.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @name: UserRepository
 * @author: IhaveBB
 * @date: 2024-10-21 22:58
 **/
public interface UserRepository extends JpaRepository<User, Long> {}
