package com.musinsa.problem.cody.domain.model;

import com.musinsa.problem.cody.domain.entity.BrandRepository;
import com.musinsa.problem.cody.domain.entity.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClothesModel {

    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
}
