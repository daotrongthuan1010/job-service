package com.job.future.jobservice.api.response.postcontent;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.job.future.jobservice.api.response.comment.GetCommentByTitleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

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
    private String views;

    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

    @JsonProperty(value = "rating_avg")
    private String ratingAvg;

    @JsonProperty(value = "comments")
   private List<GetCommentByTitleResponse> comments;


}
