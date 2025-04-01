package com.musinsa.problem.cody.domain.entity;

import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ClothesRepositoryCustom {
}
