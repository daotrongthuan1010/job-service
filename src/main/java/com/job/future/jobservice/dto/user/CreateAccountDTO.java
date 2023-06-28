package com.job.future.jobservice.dto.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAccountDTO {

    private final String username;

    private final String password;

    private final String fullName;

    private final String numberPhone;

    private final String email;

}
