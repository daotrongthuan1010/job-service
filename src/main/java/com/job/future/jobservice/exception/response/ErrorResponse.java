package com.job.future.jobservice.exception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Getter
@Builder
public class ErrorResponse {

  @JsonProperty("result")
  private final String result;

  @JsonProperty("errorMessages")
  private final List<String> errorMessages;

}
