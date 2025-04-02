package com.musinsa.problem.cody.application;

import com.musinsa.problem.cody.application.dto.BrandPriceSummary;
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
    return new LowestPricesByCategories(clothesList.stream().mapToInt(Clothes::price).sum(),
        clothesList);
  }

  public LowestPricesByBrand calculateTotalClothesPriceByBrands() {
    List<Clothes> clothesList = clothesModel.getLowestPriceClothesByBrands();
    // 빈 리스트 에러 처리
    return new LowestPricesByBrand(clothesList.get(0).brandName(), clothesList.stream().map(
        clothes -> new LowestPricesByBrand.CategoryPriceSummary(clothes.category().getDisplayName(),
            clothes.price())).toList(), clothesList.stream().mapToInt(Clothes::price).sum());
  }
}
