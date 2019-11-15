package com.shopping.product.controller

import com.shopping.product.dto.LoginRequestDTO
import com.shopping.product.dto.RegisterRequestDTO
import com.shopping.product.model.User
import com.shopping.product.service.UserServiceTrait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping('/api/v1/user')
class UserController {

  @Autowired
  private UserServiceTrait userService;

  @Autowired
  AuthenticationManager authenticationManager;

  @RequestMapping(value = '/login', method = RequestMethod.POST)
  public ResponseEntity<UserDetails> doLogin(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
    try {
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginRequestDTO.getUsername(),
              loginRequestDTO.getPassword()
          )
      );

      SecurityContextHolder.getContext().setAuthentication(authentication);
      UserDetails userDetails = authentication.getPrincipal();
      return ResponseEntity
          .status(HttpStatus.OK)
          .body(userDetails);
    } catch (Exception) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN);
    }


    return null;
  }

  @RequestMapping(value = '/register', method = RequestMethod.POST)
  public String register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
    userService.registerUser(registerRequestDTO);
  }
}
