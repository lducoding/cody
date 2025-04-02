package com.musinsa.problem.cody.infra;

import com.musinsa.problem.cody.domain.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
