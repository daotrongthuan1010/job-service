package com.job.future.jobservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class SubjectDto {

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String description;
}
