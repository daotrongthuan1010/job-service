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
public class MailValidator implements ConstraintValidator<Mail, String> {

  private final static Pattern pattern =Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    boolean result = true;

    if(StringUtils.hasLength(value)){
      result = pattern.matcher(value).matches();
    }
    return result;

  }

}
