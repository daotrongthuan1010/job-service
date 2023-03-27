package com.job.future.jobservice.utils;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class GetMessageError {

  private MessageSource messageSource;

  public String getErrorMessage(String key){
    return messageSource.getMessage(key, null, Locale.getDefault());
  }

  public String getErrorMessage(HttpStatus status){
    return messageSource.getMessage("Not_Found", null, Locale.getDefault());
  }
}
