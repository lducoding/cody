package com.musinsa.problem.cody.domain.model;

import static com.musinsa.problem.cody.common.exception.ExceptionConstants.ERROR_NO_CLOTHES_DATA_ERROR;

import com.musinsa.problem.cody.common.exception.IllegalStateException;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ClothesModel {

  private final ClothesRepositoryCustom clothesRepositoryCustom;

  public ClothesModel(ClothesRepositoryCustom clothesRepositoryCustom) {
    this.clothesRepositoryCustom = clothesRepositoryCustom;
  }


  /***
   * 카테고리별 최저가격의 Clothes를 조회함
   * 중복되는 가격이 있는 경우 Brand를 골고루 보여주기 위해 가장 적게 조회된 Brand를 노출시킴
   * 그래도 중복이 사라지지 않는 경우 BrandName order by desc로 제일 우선인 Brnad를 노출시킴
   */
  public List<Clothes> getLowestPriceClothesByCategories() {
    List<Clothes> rawList = clothesRepositoryCustom.clothesFindLowestPriceByCategory();
    if (rawList == null || rawList.isEmpty()) {
      throw new IllegalStateException(ERROR_NO_CLOTHES_DATA_ERROR, "조회된 의류 데이터가 없습니다.");
    }

    // 브랜드 이름별 등장 횟수를 체크하기 위한 Map
    Map<String, Long> brandCount = rawList.stream()
        .collect(Collectors.groupingBy(Clothes::brandName, Collectors.counting()));

    // category별 Clothes 정보를 조회 순서대로 저장 (입력 순서 유지)
    Map<Category, List<Clothes>> groupedByCategory = rawList.stream()
        .collect(Collectors.groupingBy(Clothes::category, LinkedHashMap::new, Collectors.toList()));

    List<Clothes> result = new ArrayList<>();
    for (Map.Entry<Category, List<Clothes>> entry : groupedByCategory.entrySet()) {
      List<Clothes> items = entry.getValue();
      Clothes clothes = null;

      if (items.size() == 1) {
        clothes = items.get(0);
      }
      if (items.size() > 1) {
        // 여러 개일 경우, 각 의류의 브랜드 등장 횟수(brandCount)를 비교하여
        // 가장 적은 횟수를 가진 Clothes를 선택
        // 그래도 중복일 경우 brnadName 역순으로 제일먼저 오는 값을 선택
        clothes = items.stream()
            .min(Comparator
                .comparingLong((Clothes c) -> brandCount.get(c.brandName()))
                .thenComparing(Clothes::brandName, Comparator.reverseOrder()))
            .orElseThrow(
                () -> new IllegalStateException(ERROR_NO_CLOTHES_DATA_ERROR, "조회된 의류 데이터가 없습니다."));
      }
      result.add(clothes);
    }
    return result;
  }

  public List<Clothes> getLowestPriceClothesByBrands() {
    return clothesRepositoryCustom.clothesFindLowestPriceByBrand();
  }

  public List<Clothes> getMinAndMaxClothesByCategory(Category category) {
    return clothesRepositoryCustom.clothesFindAllByCategory(category);
  }
}
