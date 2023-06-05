package com.job.future.jobservice.api.request.postcontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class PostPostContentApiRequest {

    private final String id;

    private final String code;

    private final String title;

    private final String content;

}
