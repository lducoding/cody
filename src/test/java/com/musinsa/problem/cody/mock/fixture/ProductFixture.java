package com.musinsa.problem.cody.mock.fixture;

import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.enums.Category;

public class ProductFixture {

  public static Brand product관련_테스트를_위한_brand_객체T_1개_생성() {
    return new Brand("T");
  }

  public static Brand product관련_테스트를_위한_brand_객체T2_1개_생성() {
    return new Brand("T2");
  }

  public static Product product관련_테스트를_위한_TOP_product_객체_1개_생성(Brand brand) {
    return new Product(Category.TOP, 1000, 1, brand);
  }
}
