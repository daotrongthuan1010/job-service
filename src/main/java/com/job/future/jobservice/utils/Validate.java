package com.job.future.jobservice.utils;



/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */


public class Validate {


//  public Validate() {
//    validator = new LocalValidatorFactoryBean();
//  }
//
//  /**
//   * Validates the given object using the default validator and returns a map of validation errors
//   * grouped by error type.
//   *
//   * @param object the object to validate
//   * @param <T> the type of the object to validate
//   * @return a map of validation errors grouped by error type
//   * @throws jakarta.validation.ValidationException if an error occurs while validating the object
//   * @author daotrongthuan1010
//   */
//  public static <T> Map<Class<?>, List<String>> validateAndGetErrorMessages(T object) {
//    Set<ConstraintViolation<T>> violations = validator.validate(object);
//    return violations.stream()
//        .collect(Collectors.groupingBy(
//            v -> v.getConstraintDescriptor().getAnnotation().annotationType(),
//            Collectors.mapping(ConstraintViolation::getMessage, Collectors.toList())));
//  }


}
