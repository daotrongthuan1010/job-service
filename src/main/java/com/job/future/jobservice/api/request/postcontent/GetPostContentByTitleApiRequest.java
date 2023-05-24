package com.job.future.jobservice.api.request.postcontent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetPostContentByTitleApiRequest {

    private final String title;
}
