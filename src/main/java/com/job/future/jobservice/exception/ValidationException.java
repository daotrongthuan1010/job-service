package com.job.future.jobservice.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Getter
@NoArgsConstructor
public class ValidationException extends RuntimeException {

  private Map<String, List<String>> errors = new HashMap<>();

  private List<String> errorMessages = new ArrayList<>();

  public ValidationException(Map<String, List<String>> errors, List<String> errorMessages) {
    this.errors = errors;
    this.errorMessages = errorMessages;
  }

}
