package com.musinsa.problem.cody.infra;

import com.musinsa.problem.cody.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ClothesRepository {

}
