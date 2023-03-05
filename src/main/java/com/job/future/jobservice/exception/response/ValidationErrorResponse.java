package com.job.future.jobservice.exception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Getter
@Builder
public class ValidationErrorResponse {

  @JsonProperty("result")
  private final String result;

  @JsonProperty("errorMessages")
  private final List<String> errorMessages;

  @JsonProperty("validationErrors")
  private final ValidationErrors validationErrors;

  @Getter
  @Builder
  public static class ValidationErrors {

    @JsonProperty("title")
    private final String title;

    @JsonProperty("errors")
    private final List<Errors> errors;
  }

  @Getter
  @Builder
  @EqualsAndHashCode
  public static class Errors {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("messages")
    private final List<String> messages;

  }


}
