package com.job.future.jobservice.api.request.postcontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostPostContentApiRequest {

    private final String code;

    private final String title;

    private final String content;

}
