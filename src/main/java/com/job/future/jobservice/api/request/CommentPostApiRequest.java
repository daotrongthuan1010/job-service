package com.job.future.jobservice.api.request;

import com.job.future.jobservice.validate.Max;
import javax.validation.constraints.NotNull;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

public class CommentPostApiRequest {

  @NotNull
  @Max(value = 1000)
  private String content;

}
