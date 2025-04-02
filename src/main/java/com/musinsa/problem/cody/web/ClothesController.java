package com.musinsa.problem.cody.web;

import com.musinsa.problem.cody.application.ClothesService;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.web.dto.CategoryMinMaxPrice;
import com.musinsa.problem.cody.web.dto.LowestPricesByBrand;
import com.musinsa.problem.cody.web.dto.LowestPricesByCategories;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clothes/v1")
@RequiredArgsConstructor
public class ClothesController {

  private final ClothesService clothesService;

  @GetMapping("/lowest-prices/categories")
  public ResponseEntity<LowestPricesByCategories> getLowestPricesByCategories() {
    return ResponseEntity.ok(clothesService.calculateTotalClothesPriceByCategories());
  }

  @GetMapping("/lowest-prices/brands")
  public ResponseEntity<Map<String, LowestPricesByBrand>> getLowestPricesBybrand() {
    return ResponseEntity.ok(
        Map.of("lowestPrice", clothesService.calculateTotalClothesPriceByBrands()));
  }

  @GetMapping("/lowest-prices/categories/{categoryName}")
  public ResponseEntity<CategoryMinMaxPrice> getLowestAndHighestPricesByCategoryName(
      @PathVariable(name = "categoryName") Category categoryName) {
    return ResponseEntity.ok(clothesService.getLowestAndHighestPricesByCategoryName(categoryName));
  }
}
