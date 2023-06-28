package com.job.future.jobservice.api.request.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginAccountApiRequest {

    private final String username;

    private final String password;

}
