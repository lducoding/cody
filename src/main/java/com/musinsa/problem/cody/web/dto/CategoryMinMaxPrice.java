package com.musinsa.problem.cody.web.dto;

import com.musinsa.problem.cody.application.dto.BrandPriceSummary;

public record CategoryMinMaxPrice(
    String category,
    BrandPriceSummary minBrandPriceSummary,
    BrandPriceSummary maxBrandPriceSummary) {}
