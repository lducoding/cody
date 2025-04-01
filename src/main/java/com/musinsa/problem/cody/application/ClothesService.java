package com.musinsa.problem.cody.application;

import com.musinsa.problem.cody.domain.model.ClothesModel;
import com.musinsa.problem.cody.web.dto.LowestPricesByCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClothesService {

    private final ClothesModel clothesModel;

    public LowestPricesByCategories calculateTotalClothesPrice() {
        return new LowestPricesByCategories(0, List.of());
    }

}
