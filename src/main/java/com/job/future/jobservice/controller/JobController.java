package com.job.future.jobservice.controller;

import com.job.future.jobservice.api.request.PostJobApiRequest;
import com.job.future.jobservice.controller.usecase.PostJobUseCase;
import com.job.future.jobservice.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

  private final PostJobUseCase useCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/post_job")
  public void index(@RequestBody PostJobApiRequest request, Authentication authentication) throws ServiceException {
    String username = authentication.getName();
    useCase.execute(request);
  }


}
