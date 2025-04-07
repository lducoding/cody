package com.musinsa.problem.cody.domain.entity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

  Optional<Brand> findByIdAndDeletedAtIsNull(Long id);
}
