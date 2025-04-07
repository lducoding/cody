package com.musinsa.problem.cody.integration.application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.musinsa.problem.cody.application.ClothesService;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.domain.entity.ProductRepository;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.model.ClothesModel;
import com.musinsa.problem.cody.integration.IntegrationSupport;
import com.musinsa.problem.cody.web.dto.CategoryMinMaxPrice;
import com.musinsa.problem.cody.web.dto.LowestPricesByBrand;
import com.musinsa.problem.cody.web.dto.LowestPricesByCategories;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Rollback
public class ClothesServiceTest extends IntegrationSupport {

  @Autowired ClothesService clothesService;
  @Autowired ClothesModel clothesModel;
  @Autowired BrandRepository brandRepository;
  @Autowired ProductRepository productRepository;

  @DisplayName("옷들의 가격 총합을 구한다.")
  @Test
  void calculateTotalClothesPrice_test() {
    // given
    super.saveInit_카테고리별_조회시_가장낮은_제품들의_총액합이_21000();

    // when
    LowestPricesByCategories lowestPricesByCategories =
        clothesService.calculateTotalClothesPriceByCategories();

    // then
    Assertions.assertThat(lowestPricesByCategories).isNotNull();
    assertThat(lowestPricesByCategories.totalCount()).isEqualTo(21000);
  }

  @DisplayName("최저가격 브랜드 조회시 totalCount 계산 확인")
  @Test
  void calculateTotalClothesPriceByBrands_totalCount_test() {
    // given
    super.saveInit_단일브랜드로_조회시_총액합이_가장낮은브랜드는_B_총액합은_20000();

    // when
    LowestPricesByBrand lowestPricesByBrand = clothesService.calculateTotalClothesPriceByBrands();

    // then
    Assertions.assertThat(lowestPricesByBrand).isNotNull();
    Assertions.assertThat(lowestPricesByBrand.totalCount()).isEqualTo(20000);
    Assertions.assertThat(lowestPricesByBrand.brandName()).isEqualTo("B");
  }

  @DisplayName("카테고리를 인자로 받아 최저가격 브랜드 최고 가격 브랜드 확인")
  @Test
  void getLowestAndHighestPricesByCategoryName_test() {
    // given
    super.saveInit_카테고리TOP를_인자로_받아_조회시_가격이_가장낮은브랜드는_B_1000원_가격이_가장높은브랜드는_A_100000원();

    // when
    CategoryMinMaxPrice lowestAndHighestPricesByCategoryName =
        clothesService.getLowestAndHighestPricesByCategoryName(Category.TOP);

    // then
    Assertions.assertThat(lowestAndHighestPricesByCategoryName).isNotNull();
    Assertions.assertThat(lowestAndHighestPricesByCategoryName.minBrandPriceSummary().brand())
        .isEqualTo("B");
    Assertions.assertThat(lowestAndHighestPricesByCategoryName.minBrandPriceSummary().price())
        .isEqualTo(1000);
    Assertions.assertThat(lowestAndHighestPricesByCategoryName.maxBrandPriceSummary().brand())
        .isEqualTo("A");
    Assertions.assertThat(lowestAndHighestPricesByCategoryName.maxBrandPriceSummary().price())
        .isEqualTo(100000);
  }
}
