package com.musinsa.problem.cody.infra;

import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import java.util.List;

public interface ClothesRepositoryCustom {

  List<Clothes> clothesFindLowestPriceByCategory();

  List<Clothes> clothesFindLowestPriceByBrand();

  List<Clothes> clothesFindAllByCategory(Category category);
}
