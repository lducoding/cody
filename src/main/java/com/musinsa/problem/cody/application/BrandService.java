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
}
