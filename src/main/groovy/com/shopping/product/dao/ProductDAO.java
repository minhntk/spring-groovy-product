package com.shopping.product.dao;

import com.shopping.product.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductDAO extends AbstractJpaDAO {

  public ProductDAO() {
    super();
    setClazz(Product.class);
  }

  public List<Product> getProductsByUserId() {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
    Root<Product> root = criteriaQuery.from(Product.class);
    criteriaQuery.select(root);

    TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
    List<Product> results = query.getResultList();
    return results;
  }
}
