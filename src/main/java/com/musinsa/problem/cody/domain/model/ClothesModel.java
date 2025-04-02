package com.musinsa.problem.cody.domain.model;

import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.infra.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClothesModel {

  private final ProductRepository productRepository;

  public List<Clothes> getLowestPriceClothesByCategories() {
    return productRepository.clothesFindLowestPriceByCategory();
  }

  public List<Clothes> getLowestPriceClothesByBrands() {
    return productRepository.clothesFindLowestPriceByBrand();
  }

  public List<Clothes> getMinAndMaxClothesByCategory(Category category) {
    return productRepository.clothesFindAllByCategory(category);
  }
}
