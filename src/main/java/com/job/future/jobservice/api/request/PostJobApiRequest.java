package com.job.future.jobservice.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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


  private final String code;


  private final String name;


  private final Double salaryAvg;


  private final String status;


  private final Long idJobPath;


  private final Long idCategoryJob;

}
