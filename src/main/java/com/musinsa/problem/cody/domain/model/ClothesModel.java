package com.musinsa.problem.cody.domain.model;

import com.musinsa.problem.cody.common.exception.IllegalStateException;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;
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

  public List<Clothes> getLowestPriceClothesByCategories() {
    List<Clothes> rawList = clothesRepositoryCustom.clothesFindLowestPriceByCategory();
    if (rawList == null || rawList.isEmpty()) {
      throw new IllegalStateException(500001, "조회된 의류 데이터가 없습니다.");
    }
    Map<String, Long> brandCount =
        rawList.stream().collect(Collectors.groupingBy(Clothes::brandName, Collectors.counting()));

    return rawList.stream()
        .collect(Collectors.groupingBy(Clothes::category, LinkedHashMap::new, Collectors.toList()))
        .values()
        .stream()
        .map(
            items ->
                items.size() == 1
                    ? items.get(0)
                    : items.stream()
                        .filter(c -> brandCount.get(c.brandName()) == 1)
                        .findFirst()
                        .orElseGet(
                            () ->
                                items.stream()
                                    .max(Comparator.comparing(Clothes::brandName))
                                    .orElse(items.get(0))))
        .collect(Collectors.toList());
  }

  public List<Clothes> getLowestPriceClothesByBrands() {
    return clothesRepositoryCustom.clothesFindLowestPriceByBrand();
  }

  public List<Clothes> getMinAndMaxClothesByCategory(Category category) {
    return clothesRepositoryCustom.clothesFindAllByCategory(category);
  }
}
