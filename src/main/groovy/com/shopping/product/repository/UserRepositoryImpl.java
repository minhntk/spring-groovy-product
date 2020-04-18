package com.shopping.product.repository;

import com.shopping.product.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserCustomRepository {
  @Override
  public List<User> findAll() {
    return null;
  }
}
