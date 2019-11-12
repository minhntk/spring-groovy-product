package com.shopping.product.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
class Product {
  public Product() {
  }

  @Id
  private UUID productId;


}
