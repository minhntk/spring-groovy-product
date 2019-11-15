package com.shopping.product.controller

import com.shopping.product.model.Product
import com.shopping.product.service.ProductServiceTrait
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/api/v1/products')
class ProductController {

  @Autowired
  private ProductServiceTrait productService;

  @RequestMapping(value = '/list', method = RequestMethod.GET)
  public List<Product> getListOfProducts() {
    return productService.getAllProducts()
  }
}
