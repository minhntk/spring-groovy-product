package com.shopping.product.service

import com.shopping.product.model.User
import com.shopping.product.model.UserPrincipal
import com.shopping.product.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserServiceTrait userServiceTrait;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional(readOnly = true)
  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    User user = userServiceTrait.findUserByUserName(username);
//    return user;
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    System.out.println(passwordEncoder.encode("admin@123"));
    return new UserPrincipal(user);
  }
}
