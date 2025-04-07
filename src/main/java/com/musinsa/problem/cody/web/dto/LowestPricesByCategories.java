package com.musinsa.problem.cody.web.dto;

import com.musinsa.problem.cody.domain.vo.Clothes;

import java.util.List;

public record LowestPricesByCategories(int totalCount, List<Clothes> clothesList) {}
