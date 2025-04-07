package com.musinsa.problem.cody.integration.application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.musinsa.problem.cody.application.ProductService;
import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.domain.entity.Product;
import com.musinsa.problem.cody.domain.entity.ProductRepository;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.model.ClothesModel;
import com.musinsa.problem.cody.integration.IntegrationSupport;
import com.musinsa.problem.cody.web.dto.ProductDataRequest;
import com.musinsa.problem.cody.web.dto.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Rollback
public class ProductServiceTest extends IntegrationSupport {

  @Autowired ProductService productService;
  @Autowired ClothesModel clothesModel;
  @Autowired BrandRepository brandRepository;
  @Autowired ProductRepository productRepository;

  @DisplayName("product 엔티티 생성후 ProductResponse 리턴")
  @Test
  void createProduct_test() {
    // given
    Brand brand = super.saveInit_product관련_테스트를_위한_brand_객체T_1개_생성();
    Category category = Category.TOP;
    int price = 1000;
    int categoryOrderNumber = 1;

    ProductDataRequest productDataRequest =
        new ProductDataRequest(category, price, categoryOrderNumber, brand.getId());

    // when
    ProductResponse productResponse = productService.createProduct(productDataRequest);

    // then
    assertThat(productResponse).isNotNull();
    assertThat(productResponse.getCategory()).isEqualTo(category);
    assertThat(productResponse.getPrice()).isEqualTo(price);
    assertThat(productResponse.getCategoryOrderNumber()).isEqualTo(categoryOrderNumber);
    assertThat(productResponse.getBrandId()).isEqualTo(brand.getId());
  }

  @DisplayName("product 엔티티 update후 BrandResponse 리턴")
  @Test
  void updateBrand_test() {
    // given
    Product product = super.saveInit_product관련_테스트를_위한_TOP_product_객체_1개_생성();
    Category updateCategory = Category.PANTS;
    int updatePrice = 3000;
    int updateCategoryOrderNumber = 2;
    Brand updateBrand = super.saveInit_product관련_테스트를_위한_brand_객체T2_1개_생성();
    ProductDataRequest productDataRequest =
        new ProductDataRequest(
            updateCategory, updatePrice, updateCategoryOrderNumber, updateBrand.getId());

    // when
    ProductResponse productResponse =
        productService.updateProduct(product.getId(), productDataRequest);

    // then
    assertThat(productResponse).isNotNull();
    assertThat(productResponse.getCategory()).isEqualTo(updateCategory);
    assertThat(productResponse.getPrice()).isEqualTo(updatePrice);
    assertThat(productResponse.getCategoryOrderNumber()).isEqualTo(updateCategoryOrderNumber);
    assertThat(productResponse.getBrandId()).isEqualTo(updateBrand.getId());
  }
}
