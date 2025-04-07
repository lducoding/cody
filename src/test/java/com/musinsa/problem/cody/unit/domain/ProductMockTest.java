package com.musinsa.problem.cody.unit.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.musinsa.problem.cody.application.ProductService;
import com.musinsa.problem.cody.common.exception.NotFoundException;
import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.ProductRepository;
import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.web.dto.ProductDataRequest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductMockTest {

  @Mock private ProductRepository productRepository;

  @InjectMocks private ProductService productService;

  @DisplayName("Product update시 조회되는 Product가 없는 경우 에러 테스트")
  @Test
  void updateProduct_no_product_error_test() {
    // given
    Long id = 1L;
    Brand brand = new Brand("T1");
    Category category = Category.TOP;
    int price = 1000;
    int categoryOrderNumber = 1;

    ProductDataRequest productDataRequest =
        new ProductDataRequest(category, price, categoryOrderNumber, brand.getId());

    given(productRepository.findByIdAndDeletedAtIsNull(any())).willReturn(Optional.empty());

    assertThrows(
        NotFoundException.class, () -> productService.updateProduct(id, productDataRequest));
  }

  @DisplayName("Product delete시 조회되는 Product가 없는 경우 에러 테스트")
  @Test
  void deleteProduct_no_product_error_test() {
    // given
    Long id = 1L;

    given(productRepository.findByIdAndDeletedAtIsNull(any())).willReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> productService.deleteProduct(id));
  }
}
