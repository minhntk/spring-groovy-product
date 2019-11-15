package com.shopping.product.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp

import javax.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "shops")
class Shop {

  @Id
  @GeneratedValue(
      strategy = GenerationType.AUTO,
      generator = "pg-uuid"
  )
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "shop_id")
  private UUID shopId;

  @Column(name = "shop_name")
  private String shopName;

  @Column(name = "owned_by")
  private UUID ownedById;

  @ManyToOne(optional = false)
  @JoinColumn(name = "owned_by", nullable = false, insertable = false, updatable = false)
  private User ownedBy;

  @CreationTimestamp
  @Column(name = "created_on")
  private Timestamp createdOn;

  @UpdateTimestamp
  @Column(name = "updated_on")
  private Timestamp updatedOn;

  @Column(name = "is_active")
  private boolean isActive;

  @Column(name = "is_approved")
  private boolean isApproved;

  public Shop() {
  }

  UUID getShopId() {
    return shopId
  }

  void setShopId(UUID shopId) {
    this.shopId = shopId
  }

  String getShopName() {
    return shopName
  }

  void setShopName(String shopName) {
    this.shopName = shopName
  }

  UUID getOwnedById() {
    return ownedById
  }

  void setOwnedById(UUID ownedById) {
    this.ownedById = ownedById
  }

  User getOwnedBy() {
    return ownedBy
  }

  void setOwnedBy(User ownedBy) {
    this.ownedBy = ownedBy
  }

  Timestamp getCreatedOn() {
    return createdOn
  }

  void setCreatedOn(Timestamp createdOn) {
    this.createdOn = createdOn
  }

  Timestamp getUpdatedOn() {
    return updatedOn
  }

  void setUpdatedOn(Timestamp updatedOn) {
    this.updatedOn = updatedOn
  }

  boolean getIsActive() {
    return isActive
  }

  void setIsActive(boolean isActive) {
    this.isActive = isActive
  }

  boolean getIsApproved() {
    return isApproved
  }

  void setIsApproved(boolean isApproved) {
    this.isApproved = isApproved
  }
}
