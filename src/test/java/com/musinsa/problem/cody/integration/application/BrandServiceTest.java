package com.musinsa.problem.cody.integration.application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.musinsa.problem.cody.application.BrandService;
import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.integration.IntegrationSupport;
import com.musinsa.problem.cody.web.dto.BrandDataRequest;
import com.musinsa.problem.cody.web.dto.BrandResponse;
import java.time.Instant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Rollback
public class BrandServiceTest extends IntegrationSupport {

  @Autowired BrandService brandService;

  @DisplayName("브랜드 엔티티 생성후 BrandResponse 리턴")
  @Test
  void createBrand_test() {
    // given
    String brandName = "T";
    BrandDataRequest brandDataRequest = new BrandDataRequest(brandName);

    // when
    BrandResponse brandResponse = brandService.createBrand(brandDataRequest);

    // then
    assertThat(brandResponse).isNotNull();
    assertThat(brandResponse.getName()).isEqualTo(brandName);
  }

  @DisplayName("브랜드 엔티티 update후 BrandResponse 리턴")
  @Test
  void updateBrand_test() {
    // given
    Brand brand = super.saveInit_brand관련_테스트를_위한_brand_객체_1개_생성();
    String updateBrandName = "T-1";
    BrandDataRequest brandDataRequest = new BrandDataRequest(updateBrandName);

    // when
    BrandResponse brandResponse = brandService.updateBrand(brand.getId(), brandDataRequest);

    // then
    assertThat(brandResponse).isNotNull();
    assertThat(brandResponse.getName()).isEqualTo(updateBrandName);
  }

  @DisplayName("브랜드 엔티티 delete후 deletedAt의 데이터가 존재함")
  @Test
  void deleteBrand_test() {
    // given
    Brand brand = super.saveInit_brand관련_테스트를_위한_brand_객체_1개_생성();

    // when
    Instant instant = brandService.deleteBrand(brand.getId());

    // then
    assertThat(brand.delete()).isNotNull();
  }
}
