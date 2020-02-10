package com.shopping.product.dao;

import com.shopping.product.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAO extends AbstractJpaDAO {

  public RoleDAO() {
    super();
    setClazz(Role.class);
  }
}
