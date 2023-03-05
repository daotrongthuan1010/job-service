package com.job.future.jobservice.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessagePropertiesConstants {

  //Check valition input to screen.
  public static final String RESPONSE_VALIDATION_400 = "response.jakarta.message.validation.400";

  public static final String RESPONSE_400 = "response.jakarta.message.400";

  public static final String RESPONSE_401 = "response.jakarta.message.401";

  public static final String RESPONSE_403 = "response.jakarta.message.403";
  //Check not found
  public static final String RESPONSE_404 = "response.jakarta.message.404";

  public static final String RESPONSE_409 = "response.jakarta.message.409";
  //Check error
  public static final String RESPONSE_500 = "response.jakarta.message.500";


}
