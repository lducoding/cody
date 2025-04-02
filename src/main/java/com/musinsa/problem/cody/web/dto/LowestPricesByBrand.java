package com.musinsa.problem.cody.web.dto;

import java.util.List;

public record LowestPricesByBrand(String brandName, List<CategoryPriceSummary> categories,
                                  int totalCount) {

  public record CategoryPriceSummary(String category, int price) {

  }
}
