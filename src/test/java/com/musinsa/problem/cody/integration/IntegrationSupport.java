package com.musinsa.problem.cody.integration;

import com.musinsa.problem.cody.TestConfig;
import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.entity.ProductRepository;
import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;
import com.musinsa.problem.cody.mock.fixture.BrandFixture;
import com.musinsa.problem.cody.mock.fixture.ClothesFixture;
import com.musinsa.problem.cody.mock.fixture.ProductFixture;
import java.util.List;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = {TestConfig.class})
public abstract class IntegrationSupport {

  @Autowired protected ClothesRepositoryCustom clothesRepositoryCustom;
  @Autowired private BrandRepository brandRepository;
  @Autowired private ProductRepository productRepository;

  protected void saveInit_카테고리별_조회시_가장낮은_제품들의_총액합이_21000() {
    List<Brand> brands = brandRepository.saveAll(ClothesFixture.A_B_C_3개의브랜드_생성());
    productRepository.saveAll(ClothesFixture.카테고리별_조회시_가장낮은_제품들의_총액합이_21000(brands));
  }

  protected void saveInit_단일브랜드로_조회시_총액합이_가장낮은브랜드는_B_총액합은_20000() {
    List<Brand> brands = brandRepository.saveAll(ClothesFixture.A_B_C_3개의브랜드_생성());
    productRepository.saveAll(ClothesFixture.단일브랜드로_조회시_총액합이_가장낮은브랜드는_B_총액합은_20000(brands));
  }

  protected void saveInit_카테고리TOP를_인자로_받아_조회시_가격이_가장낮은브랜드는_B_1000원_가격이_가장높은브랜드는_A_100000원() {
    List<Brand> brands = brandRepository.saveAll(ClothesFixture.A_B_C_3개의브랜드_생성());
    productRepository.saveAll(
        ClothesFixture.카테고리TOP를_인자로_받아_조회시_가격이_가장낮은브랜드는_B_1000원_가격이_가장높은브랜드는_A_100000원(brands));
  }

  protected Brand saveInit_brand관련_테스트를_위한_brand_객체_1개_생성() {
    return brandRepository.save(BrandFixture.brand관련_테스트를_위한_brand_객체_1개_생성());
  }

  protected Brand saveInit_product관련_테스트를_위한_brand_객체T_1개_생성() {
    return brandRepository.save(ProductFixture.product관련_테스트를_위한_brand_객체T_1개_생성());
  }

  protected Product saveInit_product관련_테스트를_위한_TOP_product_객체_1개_생성() {
    return productRepository.save(
        ProductFixture.product관련_테스트를_위한_TOP_product_객체_1개_생성(
            saveInit_product관련_테스트를_위한_brand_객체T_1개_생성()));
  }

  protected Brand saveInit_product관련_테스트를_위한_brand_객체T2_1개_생성() {
    return brandRepository.save(ProductFixture.product관련_테스트를_위한_brand_객체T2_1개_생성());
  }
}
