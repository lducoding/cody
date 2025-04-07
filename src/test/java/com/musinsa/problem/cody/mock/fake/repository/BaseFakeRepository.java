package com.musinsa.problem.cody.mock.fake.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class BaseFakeRepository<Z, ID> {

  private final Supplier<ID> idGenerator;
  private final List<Z> data = Collections.synchronizedList(new ArrayList<>());

  protected BaseFakeRepository(Supplier<ID> idGenerator) {
    this.idGenerator = idGenerator;
  }

  protected abstract Z setId(Z entity, ID newId);

  protected abstract ID getId(Z entity);

  public Z save(Z entity) {
    if (getId(entity) == null) {
      Z newEntity = setId(entity, idGenerator.get());
      data.add(newEntity);
      return newEntity;
    }
    data.removeIf(item -> Objects.equals(getId(item), getId(entity)));
    data.add(entity);
    return entity;
  }

  protected List<Z> getData() {
    return data;
  }
}
