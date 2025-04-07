package com.musinsa.problem.cody.unit.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.problem.cody.application.ClothesService;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.mock.fake.model.FakeClothesModel;
import com.musinsa.problem.cody.mock.fake.repository.FakeClothesRepository;
import com.musinsa.problem.cody.web.dto.CategoryMinMaxPrice;
import com.musinsa.problem.cody.web.dto.LowestPricesByBrand;
import com.musinsa.problem.cody.web.dto.LowestPricesByCategories;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClothesServiceTest {

  private final FakeClothesRepository fakeClothesRepository = new FakeClothesRepository();

  private final FakeClothesModel clothesModel = new FakeClothesModel(fakeClothesRepository);

  private final ClothesService clothesService = new ClothesService(clothesModel);

  @DisplayName("옷들의 가격 총합을 구한다.")
  @Test
  void calculateTotalClothesPrice_test() {
    // given

    // when
    LowestPricesByCategories lowestPricesByCategories =
        clothesService.calculateTotalClothesPriceByCategories();

    // then
    assertThat(lowestPricesByCategories).isNotNull();
    assertThat(lowestPricesByCategories.totalCount()).isEqualTo(34100);
  }

  @DisplayName("List<clothes>를 CategoryPriceSummary로 잘 변환하는지 확인")
  @Test
  void clothesList_to_CategoryPriceSummary_test() {
    // given
    List<Clothes> clothesList = fakeClothesRepository.clothesFindLowestPriceByBrand();

    // when
    LowestPricesByBrand lowestPricesByBrand = clothesService.calculateTotalClothesPriceByBrands();

    // then
    assertThat(lowestPricesByBrand).isNotNull();
    assertThat(lowestPricesByBrand.categories()).hasSize(clothesList.size());
  }

  @DisplayName("최저가격 브랜드 조회시 totalCount 계산 확인")
  @Test
  void calculateTotalClothesPriceByBrands_totalCount_test() {
    // given
    List<Clothes> clothesList = fakeClothesRepository.clothesFindLowestPriceByBrand();

    int totalCount = clothesList.stream().mapToInt(Clothes::price).sum();

    // when
    LowestPricesByBrand lowestPricesByBrand = clothesService.calculateTotalClothesPriceByBrands();

    // then
    assertThat(lowestPricesByBrand).isNotNull();
    assertThat(lowestPricesByBrand.totalCount()).isEqualTo(totalCount);
  }

  @DisplayName("min max 테스트")
  @Test
  void getLowestAndHighestPricesByCategoryName_test() {
    // given
    // 상의 카테고리에서 가장싼 브랜드 B 500원
    // 상의 카테고리에서 가장비싼 브랜드 F 15000원
    Category category = Category.TOP;

    // when
    CategoryMinMaxPrice lowestAndHighestPricesByCategoryName =
        clothesService.getLowestAndHighestPricesByCategoryName(category);

    // then
    assertThat(lowestAndHighestPricesByCategoryName).isNotNull();
    assertThat(lowestAndHighestPricesByCategoryName.minBrandPriceSummary().brand()).isEqualTo("B");
    assertThat(lowestAndHighestPricesByCategoryName.minBrandPriceSummary().price()).isEqualTo(500);
    assertThat(lowestAndHighestPricesByCategoryName.maxBrandPriceSummary().brand()).isEqualTo("F");
    assertThat(lowestAndHighestPricesByCategoryName.maxBrandPriceSummary().price())
        .isEqualTo(15000);
  }
}
