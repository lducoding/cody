package com.musinsa.problem.cody.application;

import com.musinsa.problem.cody.domain.entity.Brand;
import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.web.dto.BrandDataRequest;
import com.musinsa.problem.cody.web.dto.BrandResponse;
import jakarta.persistence.EntityNotFoundException;
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
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));

    brand.updateAll(brandDataRequest.name());

    return BrandResponse.of(brand);
  }

  public Instant deleteBrand(Long id) {
    Brand brand =
        brandRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Brand not found"));

    // 이미 삭제된 경우 로직

    return brand.delete();
  }
}
