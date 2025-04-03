package com.musinsa.problem.cody.web.dto;

import com.musinsa.problem.cody.domain.entity.Brand;
import lombok.Getter;

@Getter
public class BrandResponse {

  private Long id;
  private String name;

  public BrandResponse(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public static BrandResponse of(Brand brand) {
    return new BrandResponse(brand.getId(), brand.getName());
  }
}
