package com.shopping.product.dao;

import com.shopping.product.model.Shop;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDAO extends AbstractJpaDAO {

  public ShopDAO() {
    super();
    setClazz(Shop.class);
  }

  public Shop registerShop() {
    Shop shop = new Shop();
    return shop;
  }
}
