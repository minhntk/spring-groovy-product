package com.shopping.product.service


import com.shopping.product.dto.RegisterRequestDTO
import com.shopping.product.model.Role
import com.shopping.product.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.concurrent.CompletableFuture

@Service
trait UserServiceTrait {

  @Autowired
  private RoleService roleService;

  public abstract User registerUser(RegisterRequestDTO requestDTO);

  public abstract User findUserByUserName(String username);

  public abstract CompletableFuture<User> findUser(String username);

  public User convertToUser(RegisterRequestDTO requestDTO) {
    def role = roleService.find(1L)
//    def role = new Role().tap {
//      setRoleId 1
//    }
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