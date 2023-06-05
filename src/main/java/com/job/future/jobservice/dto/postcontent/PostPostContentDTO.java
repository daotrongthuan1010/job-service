package com.job.future.jobservice.dto.postcontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Builder
public class PostPostContentDTO {

    private final String id;

    private final String code;

    private final  String title;

    private final  String content;

    private final LocalDateTime createAt;

    private final String username;

    private final String token;

}
