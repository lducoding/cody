package com.musinsa.problem.cody.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
  TOP("상의"), OUTER("아우터"), PANTS("바지"), SNEAKERS("스니커즈"), BAG("가방"), HAT("모자"), SOCKS(
      "양말"), ACCESSORIES("액세서리");

  private final String displayName;

  Category(String displayName) {
    this.displayName = displayName;
  }

  @JsonValue
  public String getDisplayName() {
    return displayName;
  }
}
