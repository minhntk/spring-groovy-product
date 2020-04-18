package com.shopping.product.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrincipal implements UserDetails {
  private User user;

  public UserPrincipal(User user) {
    this.user = user;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    if (this.user == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    if (this.user == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    if (this.user == null) {
      return false;
    }
    return true;
  }

  @Override
  public boolean isEnabled() {
    if (this.user == null) {
      return false;
    }
    return true;
  }

  public User getUserDetails() {
    return user;
  }
}
