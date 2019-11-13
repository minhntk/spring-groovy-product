package com.shopping.product.service

import com.shopping.product.dao.UserDAO
import com.shopping.product.dto.RegisterRequestDTO
import com.shopping.product.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl implements UserServiceTrait {

  @Autowired
  private UserDAO userDAO;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  User registerUser(RegisterRequestDTO requestDTO) {

    def existUser = findUserByUserName(requestDTO.getUsername())
    if (existUser != null) {
      return null;
    }
    User user = convertToUser(requestDTO)
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userDAO.create(user)
    return user;
  }

  @Override
  User findUserByUserName(String username) {
    return userDAO.findUserByUsername(username);
  }
}