package com.musinsa.problem.cody.unit.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import com.musinsa.problem.cody.common.exception.IllegalStateException;
import com.musinsa.problem.cody.domain.model.ClothesModel;
import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClothesModelMockTest {

  @Mock private ClothesRepositoryCustom clothesRepositoryCustom;

  @InjectMocks private ClothesModel clothesModel;

  @DisplayName("카테고리별 최저가격의 브랜드의 데이터가 없는 경우")
  @Test
  void calculateTotalClothesPrice_test() {
    // given
    given(clothesRepositoryCustom.clothesFindLowestPriceByCategory()).willReturn(null);

    // when
    // then
    assertThrows(
        IllegalStateException.class, () -> clothesModel.getLowestPriceClothesByCategories());
  }
}
