package com.job.future.jobservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RatingDto {

    private Double rating;

    private String content;
}
