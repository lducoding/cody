package com.musinsa.problem.cody.application;

import static com.musinsa.problem.cody.common.exception.ExceptionConstants.ERROR_CLOTHES_MINUS_DATA_ERROR;
import static com.musinsa.problem.cody.common.exception.ExceptionConstants.ERROR_NO_CLOTHES_DATA_ERROR;

import com.musinsa.problem.cody.application.dto.BrandPriceSummary;
import com.musinsa.problem.cody.common.exception.IllegalStateException;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.model.ClothesModel;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.web.dto.CategoryMinMaxPrice;
import com.musinsa.problem.cody.web.dto.LowestPricesByBrand;
import com.musinsa.problem.cody.web.dto.LowestPricesByCategories;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClothesService {

  private final ClothesModel clothesModel;

  public LowestPricesByCategories calculateTotalClothesPriceByCategories() {
    List<Clothes> clothesList = clothesModel.getLowestPriceClothesByCategories();
    return new LowestPricesByCategories(
        clothesList.stream().mapToInt(Clothes::price).sum(), clothesList);
  }

  public LowestPricesByBrand calculateTotalClothesPriceByBrands() {
    List<Clothes> clothesList = clothesModel.getLowestPriceClothesByBrands();
    if (clothesList == null || clothesList.isEmpty()) {
      throw new IllegalStateException(ERROR_NO_CLOTHES_DATA_ERROR, "조회된 의류 데이터가 없습니다.");
    }
    return new LowestPricesByBrand(
        clothesList.stream().findFirst().get().brandName(),
        clothesList.stream()
            .map(
                clothes ->
                    new LowestPricesByBrand.CategoryPriceSummary(
                        clothes.category().getDisplayName(), clothes.price()))
            .toList(),
        clothesList.stream().mapToInt(Clothes::price).sum());
  }

  public CategoryMinMaxPrice getLowestAndHighestPricesByCategoryName(Category category) {
    List<Clothes> clothesList = clothesModel.getMinAndMaxClothesByCategory(category);
    if (clothesList == null || clothesList.isEmpty()) {
      throw new IllegalStateException(ERROR_NO_CLOTHES_DATA_ERROR, "조회된 의류 데이터가 없습니다.");
    }
    Clothes minPriceClothes =
        clothesList.stream().min(Comparator.comparing(Clothes::price)).orElse(null);

    boolean hasNegativePrice = clothesList.stream().anyMatch(clothes -> clothes.price() < 0);
    if (hasNegativePrice) {
      throw new IllegalStateException(
          ERROR_CLOTHES_MINUS_DATA_ERROR, "의류의 가격이 음수인 데이터가 포함되어 있습니다.");
    }

    Clothes maxPriceClothes =
        clothesList.stream().max(Comparator.comparing(Clothes::price)).orElse(null);

    return new CategoryMinMaxPrice(
        category.getDisplayName(),
        new BrandPriceSummary(minPriceClothes.brandName(), minPriceClothes.price()),
        new BrandPriceSummary(maxPriceClothes.brandName(), maxPriceClothes.price()));
  }
}
