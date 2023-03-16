package com.job.future.jobservice.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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


  public ValidationException(List<String> errorMessages, String name, String message){
    this.errorMessages = errorMessages;
    this.errors = Collections.singletonMap(name, Arrays.asList(message));
  }

  public ValidationException(Map<String, List<String>> errors, List<String> errorMessages) {
    this.errors = errors;
    this.errorMessages = errorMessages;
  }

  public ValidationException(List<String> errorMessages){
    this.errorMessages = errorMessages;
  }

  public ValidationException(String messageKey){
    this.errorMessages = Arrays.asList(messageKey);
  }



  public String getMessage(){
    return "error validate";
  }

}
