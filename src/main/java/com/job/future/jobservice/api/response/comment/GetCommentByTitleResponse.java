package com.job.future.jobservice.api.response.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;


@Getter
@Builder
public class GetCommentByTitleResponse {

    @JsonProperty(value = "content")
    private final String content;

    @JsonProperty(value = "views")
    private final Long views;

    @JsonProperty(value = "created_update")
    private final LocalDateTime createdUpdate;

    @JsonProperty(value = "comment_reacts")
    private final String commentReactions;


}
