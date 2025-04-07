package com.musinsa.problem.cody.unit.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.problem.cody.domain.entity.Brand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BrandTest {

  @Test
  @DisplayName("Brand 정보 update 테스트")
  void brandUpdateAll_test() {
    // given
    String brandName = "T";
    String updateBrandName = "T2";

    Brand brand = new Brand(brandName);

    // when
    brand.updateAll(updateBrandName);

    // then
    assertThat(brand.getName()).isEqualTo(updateBrandName);
  }

  @Test
  @DisplayName("Brand 정보 delete 테스트")
  void brandDelete_test() {
    // given
    String brandName = "T";

    Brand brand = new Brand(brandName);

    // when
    brand.delete();

    // then
    assertThat(brand.getDeletedAt()).isNotNull();
  }
}
