package com.shopping.product.dto

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
