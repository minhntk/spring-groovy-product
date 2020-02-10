package com.shopping.product.service;

import com.shopping.product.dao.RoleDAO;
import com.shopping.product.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleDAO roleDAO;

  @Override
  public Role find(long roleId) {
    return (Role) roleDAO.findOne(roleId);
  }
}
