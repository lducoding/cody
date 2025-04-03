package com.musinsa.problem.cody.web.dto;

import com.musinsa.problem.cody.domain.enums.Category;

public record ProductDataRequest(
    Category category, int price, int categoryOrderNumber, Long brandId) {}
