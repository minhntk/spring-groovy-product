package com.shopping.product.service

import com.shopping.product.dao.ProductDAO
import com.shopping.product.model.Product
import org.springframework.beans.factory.annotation.Autowired

trait ProductServiceTrait {

  @Autowired
  private ProductDAO productDAO;

  public List<Product> getAllProducts() {
    return productDAO.findAll();
  }
}