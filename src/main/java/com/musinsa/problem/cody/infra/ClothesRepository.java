package com.musinsa.problem.cody.infra;

import com.musinsa.problem.cody.application.dto.BrandPriceSummary;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import java.util.List;
import java.util.Map;

public interface ClothesRepository {

  List<Clothes> clothesFindLowestPriceByCategory();

  List<Clothes> clothesFindLowestPriceByBrand();
