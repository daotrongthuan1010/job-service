package com.job.future.jobservice.dto;

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
public class GetCommentByPostDto {

  private String id;

  private String content;

  private Integer views;

  private LocalDateTime updatedAt;

}