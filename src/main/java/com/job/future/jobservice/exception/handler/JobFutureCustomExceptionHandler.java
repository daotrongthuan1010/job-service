package com.job.future.jobservice.exception.handler;


import com.job.future.jobservice.exception.BusinessException;
import com.job.future.jobservice.exception.ValidationException;
import com.job.future.jobservice.exception.response.ErrorResponse;
import com.job.future.jobservice.exception.response.ValidationErrorResponse;
import com.job.future.jobservice.exception.response.ValidationErrorResponse.Errors;
import com.job.future.jobservice.utils.MessagePropertiesConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class JobFutureCustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String RESULT_NG = "ng";

    private final MessageSource messageSource;

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationErrorResponse> handlerValidationException(
            ValidationException exception) {

        log.error(exception.getMessage(),
                Objects.isNull(exception.getCause()) ? exception : exception.getCause());

        List<Errors> errors = exception.getErrors().entrySet().stream()
                .map(ex -> Errors.builder().name(ex.getKey()).messages(ex.getValue()).build()).toList();

        ValidationErrorResponse.ValidationErrors validationErrors =
                ValidationErrorResponse.ValidationErrors
                        .builder()
                        .title(
                                messageSource.getMessage(MessagePropertiesConstants.RESPONSE_VALIDATION_400, null,
                                        Locale.getDefault()))
                        .errors(errors)
                        .build();

        ValidationErrorResponse response = ValidationErrorResponse.builder()
                .result(RESULT_NG)
                .validationErrors(validationErrors)
                .errorMessages(exception.getErrorMessages())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<ErrorResponse> handlerBusinessException(BusinessException ex) {
        log.error(
                CollectionUtils.isEmpty(ex.getMessages()) ? ex.getMessage() : ex.getMessage().toString(),
                Objects.isNull(ex.getCause()) ? ex :
                        ex.getCause());

        return ResponseEntity.status(ex.getStatus().orElse(HttpStatus.INTERNAL_SERVER_ERROR))
                .body(ErrorResponse.builder()
                        .result(RESULT_NG)
                        .errorMessages(CollectionUtils.isEmpty(ex.getMessages()) ?
                                Collections.singletonList(ex.getMessage()) : ex.getMessages())
                        .build());

    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handlerRuntimeException(Exception exception,
                                                          WebRequest request) {

        log.error(messageSource.getMessage("log.error.catch.Exeption", null,
                Locale.getDefault()), exception);

        ErrorResponse response =
                ErrorResponse.builder()
                        .result(RESULT_NG)
                        .errorMessages(Arrays.asList(
                                messageSource.getMessage(MessagePropertiesConstants.RESPONSE_500,
                                        null, Locale.getDefault())))
                        .build();

        return super.handleExceptionInternal(
                exception,
                response,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

}
