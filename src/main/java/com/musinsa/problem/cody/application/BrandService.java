package com.musinsa.problem.cody.application;

import static com.musinsa.problem.cody.common.exception.ExceptionConstants.ERROR_BRAND_NOT_FOUND;

import com.musinsa.problem.cody.common.exception.NotFoundException;
import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.web.dto.BrandDataRequest;
import com.musinsa.problem.cody.web.dto.BrandResponse;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandService {

  private final BrandRepository brandRepository;

  public BrandResponse createBrand(BrandDataRequest brandDataRequest) {
    return BrandResponse.of(brandRepository.save(new Brand(brandDataRequest.name())));
  }

  public BrandResponse updateBrand(Long id, BrandDataRequest brandDataRequest) {
    Brand brand =
        brandRepository
            .findByIdAndDeletedAtIsNull(id)
            .orElseThrow(
                () -> new NotFoundException(ERROR_BRAND_NOT_FOUND, "Brand가 존재하지 않습니다 id: " + id));

    brand.updateAll(brandDataRequest.name());
    return BrandResponse.of(brand);
  }

  public Instant deleteBrand(Long id) {
    Brand brand =
        brandRepository
            .findByIdAndDeletedAtIsNull(id)
            .orElseThrow(
                () -> new NotFoundException(ERROR_BRAND_NOT_FOUND, "Brand가 존재하지 않습니다 id: " + id));

    return brand.delete();
  }
}
