package com.shopping.product.dto.request

import javax.validation.constraints.NotBlank

class CreateShopRequestDTO {

  @NotBlank
  private String shopName;


}
