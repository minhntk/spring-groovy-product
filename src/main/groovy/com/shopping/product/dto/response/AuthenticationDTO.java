package com.shopping.product.dto.response;

import java.util.UUID;

public class AuthenticationDTO {
  private String userId;
  private String username;

  public AuthenticationDTO(String username, UUID userId) {
    this.username = username;
    this.userId = userId.toString();
  }
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
