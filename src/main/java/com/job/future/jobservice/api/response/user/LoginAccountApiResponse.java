package com.job.future.jobservice.api.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginAccountApiResponse {

    @JsonProperty(value = "username")
    private final String username;

    @JsonProperty(value = "token")
    private final String token;
}
