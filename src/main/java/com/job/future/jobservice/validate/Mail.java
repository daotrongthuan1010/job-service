package com.job.future.jobservice.validate;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {EmailValidator.class})
public @interface Mail {

  String message() default "{response.jakarta.validation.constraints.Mail}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
