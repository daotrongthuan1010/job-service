package com.job.future.jobservice.api.request.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAccountApiRequest {

    private final String username;

    private final String password;

    private final String fullName;

    private final String numberPhone;

    private final String email;
}
