package com.shopping.product.dao

import com.shopping.product.model.Product
import com.shopping.product.model.User
import org.springframework.stereotype.Repository

import javax.persistence.NoResultException
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Repository
class UserDAO extends AbstractJpaDAO {

  public UserDAO() {
    super();
    setClazz(Product.class);
  }

  public User findUserByUsernameAndPassword(String username, String password) {
    CriteriaBuilder criteriaBuilderObj = entityManager.getCriteriaBuilder();

    CriteriaQuery<Object> criteriaQuery = criteriaBuilderObj.createQuery();
    Root<User> root = criteriaQuery.from(User.class);
    Predicate[] predicates = new Predicate[2];
    predicates[0] = criteriaBuilderObj.equal(root.get("username"), username);
    predicates[1] = criteriaBuilderObj.equal(root.get("password"), password);
    criteriaQuery.select(root).where(predicates);
    entityManager.createQuery(criteriaQuery)
    TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
    return query.getSingleResult();
  }

  public User findUserByUsername(String username) {
    try {
      CriteriaBuilder criteriaBuilderObj = entityManager.getCriteriaBuilder();

      CriteriaQuery<Object> criteriaQuery = criteriaBuilderObj.createQuery();
      Root<User> root = criteriaQuery.from(User.class);
      Predicate[] predicates = new Predicate[1];
      predicates[0] = criteriaBuilderObj.equal(root.get("username"), username);
      criteriaQuery.select(root).where(predicates);
      entityManager.createQuery(criteriaQuery)
      TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
      return query.getSingleResult();
    } catch (NoResultException exception) {
      return null;
    }

  }

}
