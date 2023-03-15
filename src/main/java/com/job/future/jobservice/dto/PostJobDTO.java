package com.job.future.jobservice.dto;

import com.job.future.jobservice.model.Job.JobStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Data
@Builder
public class PostJobDTO {

  private String code;

  private String name;

  private Double salaryAvg;

  private int status;

  private Long idJobPath;

  private Long idCategoryJob;




}
