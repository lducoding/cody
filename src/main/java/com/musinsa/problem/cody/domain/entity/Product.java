package com.musinsa.problem.cody.domain.entity;

import com.musinsa.problem.cody.domain.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "product")
@Getter
public class Product extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Comment("PK")
  private Long id;

  @Column(name = "category")
  @Enumerated(EnumType.STRING)
  @Comment("카테고리")
  private Category category;

  @Column(name = "price")
  @Comment("가격")
  private int price;

  @Column(name = "category_order_number")
  @Comment("카테고리 기준 정렬 순서")
  private int categoryOrderNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brand_id", nullable = false)
  private Brand brand;

  public Product(Long id, Category category, int price, int categoryOrderNumber, Brand brand) {
    this.id = id;
    this.category = category;
    this.price = price;
    this.categoryOrderNumber = categoryOrderNumber;
    this.brand = brand;
  }

  public Product() {

  }
}
