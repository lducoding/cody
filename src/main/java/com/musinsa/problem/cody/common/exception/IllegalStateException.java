package com.musinsa.problem.cody.common.exception;

public class IllegalStateException extends RuntimeException implements CodyException {
  private final Integer code;
  private final String message;

  public IllegalStateException(Integer code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  @Override
  public Integer getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
