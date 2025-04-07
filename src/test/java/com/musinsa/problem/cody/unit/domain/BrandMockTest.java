package com.musinsa.problem.cody.unit.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.musinsa.problem.cody.application.BrandService;
import com.musinsa.problem.cody.common.exception.NotFoundException;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.web.dto.BrandDataRequest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BrandMockTest {

  @Mock private BrandRepository brandRepository;

  @InjectMocks private BrandService brandService;

  @DisplayName("Brand update시 조회되는 Brand가 없는 경우 에러 테스트")
  @Test
  void updateBrand_error_test() {
    // given
    String brandName = "T";
    Long id = 1L;

    BrandDataRequest brandDataRequest = new BrandDataRequest(brandName);

    given(brandRepository.findByIdAndDeletedAtIsNull(any())).willReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> brandService.updateBrand(id, brandDataRequest));
  }

  @DisplayName("Brand delete시 조회되는 Brand가 없는 경우 에러 테스트")
  @Test
  void deleteBrand_delete_error_test() {
    // given
    Long id = 1L;

    given(brandRepository.findByIdAndDeletedAtIsNull(any())).willReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> brandService.deleteBrand(id));
  }
}
