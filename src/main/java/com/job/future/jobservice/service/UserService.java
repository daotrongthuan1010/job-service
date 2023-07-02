package com.job.future.jobservice.service;

import com.job.future.jobservice.dto.user.UserDataDTO;

public interface UserService {
    String signin(String username, String password);

    String signup(UserDataDTO user);
}
