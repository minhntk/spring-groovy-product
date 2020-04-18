package com.shopping.product.repository;

import com.shopping.product.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>, UserCustomRepository {
  User findByUsername(String userName);
}
