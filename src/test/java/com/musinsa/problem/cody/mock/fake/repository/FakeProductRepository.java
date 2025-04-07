package com.musinsa.problem.cody.mock.fake.repository;

import com.musinsa.problem.cody.domain.entity.Product;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeProductRepository extends BaseFakeRepository<Product, Long> {

  private static final AtomicLong idCounter = new AtomicLong(1);

  public FakeProductRepository() {
    super(idCounter::getAndIncrement);
  }

  protected Product setId(Product entity, Long newId) {
    return new Product(
        newId,
        entity.getCategory(),
        entity.getPrice(),
        entity.getCategoryOrderNumber(),
        entity.getBrand());
  }

  protected Long getId(Product entity) {
    return entity.getId();
  }

  public Product save(Product product) {
    return super.save(product);
  }
}
