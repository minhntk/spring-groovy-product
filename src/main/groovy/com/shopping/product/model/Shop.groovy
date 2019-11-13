package com.shopping.product.model

import org.hibernate.annotations.Type

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "shops")
class Shop {

  public Shop() {
  }

  @Id
  @Column(name = "shop_id")
  @Type(type = "pg-uuid")
  private UUID shopId;

  @Column(name = "shop_name")
  private String shopName;


}
