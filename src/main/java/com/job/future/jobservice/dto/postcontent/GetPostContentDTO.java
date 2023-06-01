package com.job.future.jobservice.dto.postcontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GetPostContentDTO {

    private final String code;

    private final String title;

    private final String content;

    private final LocalDateTime createdAt;

    private final String views;

    private final String ratingAvg;

    private final String commentContent;

    private final LocalDateTime commentCreateAt;


}
