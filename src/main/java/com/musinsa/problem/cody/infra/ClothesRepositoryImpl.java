package com.musinsa.problem.cody.infra;

import com.musinsa.problem.cody.domain.enums.Category;
import com.musinsa.problem.cody.domain.vo.Clothes;
import com.musinsa.problem.cody.domain.entity.QProduct;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import jakarta.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ClothesRepositoryImpl implements ClothesRepository {

  private static final QProduct product = QProduct.product;
  private static final QProduct subProduct = new QProduct("subProduct");
  private final JPAQueryFactory queryFactory;

  public ClothesRepositoryImpl(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  @Override
  public List<Clothes> clothesFindLowestPriceByCategory() {
    return queryFactory.select(
            Projections.constructor(Clothes.class, product.brand.name, product.category, product.price))
        .from(product).where(product.price.eq(
            JPAExpressions.select(subProduct.price.min()).from(subProduct)
                .where(subProduct.category.eq(product.category))))
        .orderBy(product.categoryOrderNumber.asc()).fetch();
  }
}
