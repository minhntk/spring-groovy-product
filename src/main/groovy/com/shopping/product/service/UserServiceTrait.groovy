package com.shopping.product.service

import com.shopping.product.dao.UserDAO
import com.shopping.product.dto.RegisterRequestDTO
import com.shopping.product.model.Role
import com.shopping.product.model.User
import org.springframework.beans.factory.annotation.Autowired

trait UserServiceTrait {

  public abstract User registerUser(RegisterRequestDTO requestDTO);

  public abstract User findUserByUserName(String username);

  public User convertToUser(RegisterRequestDTO requestDTO) {
    def role = new Role().tap {
      setRoleId 1
    }
    def roles = [role]
    def user = new User().tap {
      setUsername requestDTO.getUsername()
      setEmail requestDTO.getEmail()
      setPassword requestDTO.getPassword()
      setLastName requestDTO.getLastName()
      setFirstName requestDTO.getFirstName()
      setRoles roles
      setActive true
    }
    return user
  }
}