package com.musinsa.problem.cody.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "brand")
@Getter
public class Brand extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  private Long id;

  @Column(name = "name")
  @NotNull
  @Comment("브랜드 이름")
  private String name;
}
