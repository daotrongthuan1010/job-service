package com.job.future.jobservice.api.response.postcontent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class GetPostContentByTitleResponse {
    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "content")
    private String content;

    @JsonProperty(value = "views")
    private Long views;

    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty(value = "rating_avg")
    private Double ratingAvg;
}
