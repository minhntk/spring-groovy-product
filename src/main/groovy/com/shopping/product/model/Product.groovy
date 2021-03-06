package com.shopping.product.model

import org.hibernate.annotations.Type

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
class Product {
  public Product() {
  }

  @Id
  @Column(name = "product_id")
  @Type(type = "pg-uuid")
  private UUID productId;

  private String productName;


}
