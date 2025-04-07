package com.musinsa.problem.cody.integration.infra;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.problem.cody.TestConfig;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;
import com.musinsa.problem.cody.integration.IntegrationSupport;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Rollback
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = {TestConfig.class})
public class ClothesRepositoryImplTest extends IntegrationSupport {
  @Autowired ClothesRepositoryCustom clothesRepositoryCustom;

  @Test
  @DisplayName("카테고리별로 가장 가격이 낮은 clothes 정보를 가져오는 쿼리 테스트")
  void clothesFindLowestPriceByCategory_test() {
    // given
    // A TOP(순서1) 10000, A PANTS(순서2) 8000, C SNEAKERS(순서3) 3000
    super.saveInit_카테고리별_조회시_가장낮은_제품들의_총액합이_21000();
    
    // when
    List<Clothes> clothesList = clothesRepositoryCustom.clothesFindLowestPriceByCategory();

    // then
    assertThat(clothesList).hasSize(3);
    assertThat(clothesList.get(0).category()).isEqualTo(Category.TOP);
    assertThat(clothesList.get(0).brandName()).isEqualTo("A");
    assertThat(clothesList.get(0).price()).isEqualTo(10000);
    assertThat(clothesList.get(1).category()).isEqualTo(Category.PANTS);
    assertThat(clothesList.get(1).brandName()).isEqualTo("A");
    assertThat(clothesList.get(1).price()).isEqualTo(8000);
    assertThat(clothesList.get(2).category()).isEqualTo(Category.SNEAKERS);
    assertThat(clothesList.get(2).brandName()).isEqualTo("C");
    assertThat(clothesList.get(2).price()).isEqualTo(3000);
  }

  @Test
  @DisplayName("단일 브랜드별 제품 금액 총합이 가장 낮은 브랜드의 clothes들을 조회하는 쿼리 테스트")
  void clothesFindLowestPriceByBrand_test() {
    // given
    // A 총액: 48000, B 총액 20000, C 총액 36000
    super.saveInit_단일브랜드로_조회시_총액합이_가장낮은브랜드는_B_총액합은_20000();

    // when
    // 총액이 제일 낮은 B 브랜드의 clothes 조회됨
    // TOP(순서1) 10000, PANTS(순서2) 3000, SNEAKERS(순서3) 7000,
    List<Clothes> clothesList = clothesRepositoryCustom.clothesFindLowestPriceByBrand();

    // then
    assertThat(clothesList).hasSize(3);
    assertThat(clothesList.get(0).category()).isEqualTo(Category.TOP);
    assertThat(clothesList.get(0).brandName()).isEqualTo("B");
    assertThat(clothesList.get(0).price()).isEqualTo(10000);
    assertThat(clothesList.get(1).category()).isEqualTo(Category.PANTS);
    assertThat(clothesList.get(1).brandName()).isEqualTo("B");
    assertThat(clothesList.get(1).price()).isEqualTo(3000);
    assertThat(clothesList.get(2).category()).isEqualTo(Category.SNEAKERS);
    assertThat(clothesList.get(2).brandName()).isEqualTo("B");
    assertThat(clothesList.get(2).price()).isEqualTo(7000);
  }

  @Test
  @DisplayName("카테고리로 모든 브랜드의 clothes를 구하는 쿼리 테스트")
  void clothesFindAllByCategory_test() {
    // given
    // A 100000, B 1000, C 13000
    super.saveInit_카테고리TOP를_인자로_받아_조회시_가격이_가장낮은브랜드는_B_1000원_가격이_가장높은브랜드는_A_100000원();
    Category category = Category.TOP;

    // when
    List<Clothes> clothesList = clothesRepositoryCustom.clothesFindAllByCategory(category);

    // then
    assertThat(clothesList).hasSize(3);
  }
}
