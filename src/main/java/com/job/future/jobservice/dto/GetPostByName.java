package com.job.future.jobservice.dto;

import jakarta.persistence.Column;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Data
@Builder
public class GetPostByName {

  private String code;

  private String title;

  private String content;

  private Long views;

  private LocalDateTime createdAt;

  private Double ratingAvg;

}
