package com.shopping.product.dto

import javax.validation.constraints.NotBlank

class RegisterRequestDTO {

  @NotBlank
  private String email;

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  private String lastName;

  private String firstName;

  public RegisterRequestDTO() {
  }

  String getEmail() {
    return email
  }

  void setEmail(String email) {
    this.email = email
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

  String getLastName() {
    return lastName
  }

  void setLastName(String lastName) {
    this.lastName = lastName
  }

  String getFirstName() {
    return firstName
  }

  void setFirstName(String firstName) {
    this.firstName = firstName
  }
}
