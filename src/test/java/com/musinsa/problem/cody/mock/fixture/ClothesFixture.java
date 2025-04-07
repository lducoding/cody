package com.musinsa.problem.cody.mock.fixture;

import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.enums.Category;
import java.util.List;

public class ClothesFixture {

  public static List<Brand> A_B_C_3개의브랜드_생성() {
    Brand brandA = new Brand("A");
    Brand brandB = new Brand("B");
    Brand brandC = new Brand("C");

    return List.of(brandA, brandB, brandC);
  }

  public static List<Product> 카테고리별_조회시_가장낮은_제품들의_총액합이_21000(List<Brand> brands) {
    Product brandAproductTOP = new Product(Category.TOP, 10000, 1, brands.get(0));
    Product brandBproductTOP = new Product(Category.TOP, 12000, 1, brands.get(1));
    Product brandCproductTOP = new Product(Category.TOP, 13000, 1, brands.get(2));

    Product brandAproductPANTS = new Product(Category.PANTS, 8000, 2, brands.get(0));
    Product brandBproductPANTS = new Product(Category.PANTS, 11000, 2, brands.get(1));
    Product brandCproductPANTS = new Product(Category.PANTS, 20000, 2, brands.get(2));

    Product brandAproductSNEAKERS = new Product(Category.SNEAKERS, 30000, 3, brands.get(0));
    Product brandBproductSNEAKERS = new Product(Category.SNEAKERS, 22000, 3, brands.get(1));
    Product brandCproductSNEAKERS = new Product(Category.SNEAKERS, 3000, 4, brands.get(2));

    return List.of(
        brandAproductTOP,
        brandBproductTOP,
        brandCproductTOP,
        brandAproductPANTS,
        brandBproductPANTS,
        brandCproductPANTS,
        brandAproductSNEAKERS,
        brandBproductSNEAKERS,
        brandCproductSNEAKERS);
  }

  public static List<Product> 단일브랜드로_조회시_총액합이_가장낮은브랜드는_B_총액합은_20000(List<Brand> brands) {

    Product brandAproductTOP = new Product(Category.TOP, 10000, 1, brands.get(0));
    Product brandBproductTOP = new Product(Category.TOP, 10000, 1, brands.get(1));
    Product brandCproductTOP = new Product(Category.TOP, 13000, 1, brands.get(2));

    Product brandAproductPANTS = new Product(Category.PANTS, 8000, 2, brands.get(0));
    Product brandBproductPANTS = new Product(Category.PANTS, 3000, 2, brands.get(1));
    Product brandCproductPANTS = new Product(Category.PANTS, 20000, 2, brands.get(2));

    Product brandAproductSNEAKERS = new Product(Category.SNEAKERS, 30000, 3, brands.get(0));
    Product brandBproductSNEAKERS = new Product(Category.SNEAKERS, 7000, 3, brands.get(1));
    Product brandCproductSNEAKERS = new Product(Category.SNEAKERS, 3000, 4, brands.get(2));

    return List.of(
        brandAproductTOP,
        brandBproductTOP,
        brandCproductTOP,
        brandAproductPANTS,
        brandBproductPANTS,
        brandCproductPANTS,
        brandAproductSNEAKERS,
        brandBproductSNEAKERS,
        brandCproductSNEAKERS);
  }

  public static List<Product> 카테고리TOP를_인자로_받아_조회시_가격이_가장낮은브랜드는_B_1000원_가격이_가장높은브랜드는_A_100000원(
      List<Brand> brands) {

    Product brandAproductTOP = new Product(Category.TOP, 100000, 1, brands.get(0));
    Product brandBproductTOP = new Product(Category.TOP, 1000, 1, brands.get(1));
    Product brandCproductTOP = new Product(Category.TOP, 13000, 1, brands.get(2));

    return List.of(brandAproductTOP, brandBproductTOP, brandCproductTOP);
  }
}
