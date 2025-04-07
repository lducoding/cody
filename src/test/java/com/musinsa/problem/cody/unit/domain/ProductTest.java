package com.musinsa.problem.cody.unit.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.enums.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest {

  @Test
  @DisplayName("Product 정보 update 테스트")
  void productUpdateAll_test() {
    // given
    Brand brand = new Brand("T");
    Category category = Category.TOP;
    int price = 1000;
    int categoryOrderNumber = 1;

    Brand updateBrand = new Brand("T-1");
    Category updateCategory = Category.PANTS;
    int updatePrice = 2000;
    int updateCategoryOrderNumber = 2;

    Product product = new Product(category, price, categoryOrderNumber, brand);

    // when
    product.updateAll(updateCategory, updatePrice, updateCategoryOrderNumber, updateBrand);

    // then
    assertThat(product.getPrice()).isEqualTo(updatePrice);
    assertThat(product.getCategory()).isEqualTo(updateCategory);
    assertThat(product.getCategoryOrderNumber()).isEqualTo(updateCategoryOrderNumber);
    assertThat(product.getBrand()).isEqualTo(updateBrand);
  }

  @Test
  @DisplayName("Product 정보 delete 테스트")
  void brandDelete_test() {
    // given
    Brand brand = new Brand("T");
    Category category = Category.TOP;
    int price = 1000;
    int categoryOrderNumber = 1;

    Product product = new Product(category, price, categoryOrderNumber, brand);

    // when
    product.delete();

    // then
    assertThat(product.getDeletedAt()).isNotNull();
  }
}
