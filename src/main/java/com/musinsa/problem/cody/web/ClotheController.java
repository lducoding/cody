package com.musinsa.problem.cody.web;

import com.musinsa.problem.cody.application.ClothesService;
import com.musinsa.problem.cody.web.dto.LowestPricesByCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(params = "/clothes/v1")
@RequiredArgsConstructor
public class ClotheController {

    private final ClothesService clothesService;

    @GetMapping("/categories/lowest-prices")
    public ResponseEntity<LowestPricesByCategories> getLowestPricesByCategories() {
        return ResponseEntity.ok(clothesService.calculateTotalClothesPrice());
    }
}
