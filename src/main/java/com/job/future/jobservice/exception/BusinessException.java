package com.job.future.jobservice.exception;

import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException {

  private Optional<HttpStatus> status;

  private List<String> messages;

  public BusinessException(HttpStatus status) {
    this.status = Optional.ofNullable(status);
  }

  public BusinessException(HttpStatus status, List<String> messages) {
    this.status = Optional.ofNullable(status);
    this.messages = messages;
  }

  public BusinessException(HttpStatus status, String message) {
    super(message);
    this.status = Optional.ofNullable(status);
  }

}
