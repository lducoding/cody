package com.musinsa.problem.cody.domain.model;

import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.infra.ClothesRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClothesModel {

  private final ClothesRepository clothesRepository;

  public List<Clothes> getLowestPriceClothesByCategories() {
    return clothesRepository.clothesFindLowestPriceByCategory();
  }

  public List<Clothes> getLowestPriceClothesByBrands() {
    return clothesRepository.clothesFindLowestPriceByBrand();
  }

  public List<Clothes> getMinAndMaxClothesByCategory(Category category) {
    return clothesRepository.clothesFindAllByCategory(category);
  }
}
