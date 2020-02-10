package com.shopping.product.repository;

import com.shopping.product.model.User;

import java.util.List;

public interface UserCustomRepository {
  List<User> findAll();
}
