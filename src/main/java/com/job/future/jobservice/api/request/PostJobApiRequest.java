package com.job.future.jobservice.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.job.future.jobservice.validate.Min;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Getter
@Data
@Builder
public class PostJobApiRequest {

  @NotNull
  private final String code;

  @NotNull
  private final String name;

  @Min
  private final Double salaryAvg;


  private final String status;


  private final Long idJobPath;


  private final Long idCategoryJob;

}
