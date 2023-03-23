package com.job.future.jobservice.validate;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {
  private final Pattern pattern = Pattern.compile("^(\\+\\d{1,2})?\\s*\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$");

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    boolean result = true;

    if(StringUtils.hasLength(value)){
      result = pattern.matcher(value).matches();
    }
    return result;
  }
}
