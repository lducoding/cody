package com.musinsa.problem.cody.web.dto;

import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.enums.Category;
import lombok.Getter;

@Getter
public class ProductResponse {

  private Long id;
  private Category category;

  private int price;

  private int categoryOrderNumber;

  private Long brandId;

  public ProductResponse(
      Long id, Category category, int price, int categoryOrderNumber, Long brandId) {
    this.id = id;
    this.category = category;
    this.price = price;
    this.categoryOrderNumber = categoryOrderNumber;
    this.brandId = brandId;
  }

  public static ProductResponse of(Product product) {
    return new ProductResponse(
        product.getId(),
        product.getCategory(),
        product.getPrice(),
        product.getCategoryOrderNumber(),
        product.getBrand().getId());
  }
}
