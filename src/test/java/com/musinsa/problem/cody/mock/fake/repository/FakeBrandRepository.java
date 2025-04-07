package com.musinsa.problem.cody.mock.fake.repository;

import com.musinsa.problem.cody.domain.entity.Brand;
import java.util.concurrent.atomic.AtomicLong;

public class FakeBrandRepository extends BaseFakeRepository<Brand, Long> {

  private static final AtomicLong idCounter = new AtomicLong(1);

  public FakeBrandRepository() {
    super(idCounter::getAndIncrement);
  }

  protected Brand setId(Brand entity, Long newId) {
    return new Brand(newId, entity.getName());
  }

  protected Long getId(Brand entity) {
    return entity.getId();
  }

  public Brand save(Brand brand) {
    return super.save(brand);
  }
}
