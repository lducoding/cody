package com.musinsa.problem.cody.domain.entity;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "brand")
public class Brand extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  private Long id;

  @Column(name = "name")
  @NotNull
  @Comment("브랜드 이름")
  private String name;

  public void updateAll(String name) {
    this.name = name;
  }

  public Instant delete() {
    this.deletedAt = Instant.now();
    return deletedAt;
  }

  public Brand(String name) {
    this.name = name;
  }

  public Brand(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
