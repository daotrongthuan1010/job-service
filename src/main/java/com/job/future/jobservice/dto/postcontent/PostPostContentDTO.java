package com.job.future.jobservice.dto.postcontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Builder
@AllArgsConstructor
public class PostPostContentDTO {

    private String id;

    private String code;

    private String title;

    private String content;

    private LocalDateTime createAt;


}
