package com.job.future.jobservice.dto.postcontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class GetPostContentDTO {

    private String code;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private String views;

    private String ratingAvg;

    private String commentContent;

    private LocalDateTime commentCreateAt;


}
