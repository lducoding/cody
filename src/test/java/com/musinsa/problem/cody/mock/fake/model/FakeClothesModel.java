package com.musinsa.problem.cody.mock.fake.model;

import com.musinsa.problem.cody.domain.model.ClothesModel;
import com.musinsa.problem.cody.infra.ClothesRepositoryCustom;

public class FakeClothesModel extends ClothesModel {

  public FakeClothesModel(ClothesRepositoryCustom clothesRepository) {
    super(clothesRepository);
  }
}
