package com.shopping.product.service

import com.shopping.product.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserServiceTrait userServiceTrait;

  @Override
  @Transactional(readOnly = true)
  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userServiceTrait.findUserByUserName(username);
    return user;
  }
}
