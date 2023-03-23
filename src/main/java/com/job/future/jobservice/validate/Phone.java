package com.job.future.jobservice.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = {PhoneValidator.class})
public @interface Phone {

  String message() default "{response.jakarta.validation.constraints.Phone}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload();

}
