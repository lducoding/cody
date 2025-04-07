package com.musinsa.problem.cody.mock.fake.repository;

import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;
import java.util.List;

public class FakeClothesRepository implements ClothesRepositoryCustom {

  public FakeClothesRepository() {}

  @Override
  public List<Clothes> clothesFindLowestPriceByCategory() {
    return List.of(
        new Clothes("A", Category.TOP, 10000),
        new Clothes("E", Category.OUTER, 5000),
        new Clothes("B", Category.OUTER, 5000),
        new Clothes("D", Category.PANTS, 3000),
        new Clothes("G", Category.SNEAKERS, 9000),
        new Clothes("A", Category.BAG, 2000),
        new Clothes("B", Category.BAG, 2000),
        new Clothes("D", Category.HAT, 1500),
        new Clothes("I", Category.SOCKS, 1700),
        new Clothes("F", Category.ACCESSORIES, 1900));
  }

  @Override
  public List<Clothes> clothesFindLowestPriceByBrand() {
    return List.of(
        new Clothes("D", Category.TOP, 10100),
        new Clothes("D", Category.OUTER, 5100),
        new Clothes("D", Category.PANTS, 3000),
        new Clothes("D", Category.SNEAKERS, 9500),
        new Clothes("D", Category.BAG, 2500),
        new Clothes("D", Category.HAT, 1500),
        new Clothes("D", Category.SOCKS, 2400),
        new Clothes("D", Category.ACCESSORIES, 2000));
  }

  @Override
  public List<Clothes> clothesFindAllByCategory(Category category) {
    return List.of(
        new Clothes("A", Category.TOP, 1000),
        new Clothes("B", Category.TOP, 500),
        new Clothes("C", Category.TOP, 3000),
        new Clothes("D", Category.TOP, 1500),
        new Clothes("E", Category.TOP, 10000),
        new Clothes("F", Category.TOP, 15000),
        new Clothes("G", Category.TOP, 2400),
        new Clothes("H", Category.TOP, 2000));
  }
}
