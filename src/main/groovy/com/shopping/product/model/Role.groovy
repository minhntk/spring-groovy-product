package com.shopping.product.model

import javax.persistence.*

@Entity
@Table(name = "roles")
class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long roleId;

  @Column(name = "role_name")
  private String roleName;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;

  Long getRoleId() {
    return roleId
  }

  void setRoleId(Long roleId) {
    this.roleId = roleId
  }

  String getRoleName() {
    return roleName
  }

  void setRoleName(String roleName) {
    this.roleName = roleName
  }
}
