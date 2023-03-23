package com.job.future.jobservice.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class MaxValidator implements ConstraintValidator<Max, String> {

  private long maxLong;

  @Override
  public void initialize(Max constraintAnnotation) {
    this.maxLong = constraintAnnotation.value();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if(value.isEmpty()){
      return true;
    }
    return Long.parseLong(value) <= maxLong;
  }
}
