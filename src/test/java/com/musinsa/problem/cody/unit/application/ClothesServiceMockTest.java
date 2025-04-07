package com.musinsa.problem.cody.unit.application;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import com.musinsa.problem.cody.application.ClothesService;
import com.musinsa.problem.cody.common.exception.IllegalStateException;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.model.ClothesModel;
import com.musinsa.problem.cody.domain.vo.Clothes;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClothesServiceMockTest {

  @Mock private ClothesModel clothesModel;

  @InjectMocks private ClothesService clothesService;

  @DisplayName("브랜드별 최저가격 조회시 조회된 의류 데이터가 없어 발생하는 에러 테스트")
  @Test
  void calculateTotalClothesPriceByBrands_no_clothes_error_test() {
    // given
    given(clothesModel.getLowestPriceClothesByBrands()).willReturn(null);

    assertThrows(
        IllegalStateException.class, () -> clothesService.calculateTotalClothesPriceByBrands());
  }

  @DisplayName("카테고리 이름으로 최저가격 조회시 조회된 의류 데이터가 없어 발생하는 에러 테스트")
  @Test
  void getLowestAndHighestPricesByCategoryName_no_clothes_error_test() {
    // given
    Category category = Category.TOP;
    given(clothesModel.getMinAndMaxClothesByCategory(category)).willReturn(null);

    assertThrows(
        IllegalStateException.class,
        () -> clothesService.getLowestAndHighestPricesByCategoryName(category));
  }

  @DisplayName("카테고리 이름으로 최저가격 조회시 조회된 의류 데이터의 최대 최소 가격이 음수인경우 에러 테스트")
  @Test
  void getLowestAndHighestPricesByCategoryName_error_test() {
    // given
    Category category = Category.TOP;
    given(clothesModel.getMinAndMaxClothesByCategory(category))
        .willReturn(
            List.of(new Clothes("T", Category.TOP, -1000), new Clothes("T1", Category.TOP, -2000)));

    assertThrows(
        IllegalStateException.class,
        () -> clothesService.getLowestAndHighestPricesByCategoryName(category));
  }
}
