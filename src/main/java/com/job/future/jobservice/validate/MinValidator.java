package com.job.future.jobservice.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinValidator implements ConstraintValidator<Min, String> {

  private int minValue ;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    int intValue = Integer.parseInt(value);

    if(value.isEmpty()){
      return true;
    }
    return intValue>= minValue;
  }

  @Override
  public void initialize(Min constraintAnnotation) {
    this.minValue = constraintAnnotation.value();
  }
}
