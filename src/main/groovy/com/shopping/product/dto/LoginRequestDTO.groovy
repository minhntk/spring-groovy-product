package com.shopping.product.dto

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder

import javax.validation.constraints.NotBlank

class LoginRequestDTO {

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  public LoginRequestDTO() {
  }

  String getUsername() {
    return username
  }

  void setUsername(String username) {
    this.username = username
  }

  String getPassword() {
    return password
  }

  void setPassword(String password) {
    this.password = password
  }
}
