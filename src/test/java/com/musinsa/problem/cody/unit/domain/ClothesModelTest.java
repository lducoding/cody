package com.musinsa.problem.cody.unit.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.mock.fake.model.FakeClothesModel;
import com.musinsa.problem.cody.mock.fake.repository.FakeClothesRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClothesModelTest {

  private final FakeClothesRepository fakeClothesRepository = new FakeClothesRepository();

  private final FakeClothesModel clothesModel = new FakeClothesModel(fakeClothesRepository);

  @DisplayName("카테고리별 최저가격의 브랜드가 복수 존재하는 경우 조회되지 않는 브랜드가 나오고, 그래도 중복이면 알파벳순서가 더 우선인 경우 로직 테스트")
  @Test
  void calculateTotalClothesPrice_test() {
    // given

    // when
    List<Clothes> lowestPriceClothesByCategories = clothesModel.getLowestPriceClothesByCategories();

    // then
    assertThat(lowestPriceClothesByCategories).isNotNull();
    assertThat(lowestPriceClothesByCategories.size()).isEqualTo(8);
  }
}
