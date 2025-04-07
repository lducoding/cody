package com.musinsa.problem.cody.domain.entity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByIdAndDeletedAtIsNull(Long id);
}
