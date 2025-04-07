package com.musinsa.problem.cody.common.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionConstants {

  //  404 에러
  public static final Integer ERROR_BRAND_NOT_FOUND = 404001;
  public static final Integer ERROR_PRODUCT_NOT_FOUND = 404002;

  //  500 에러
  public static final Integer ERROR_NO_CLOTHES_DATA_ERROR = 500001;
  public static final Integer ERROR_CLOTHES_MINUS_DATA_ERROR = 500002;
}
