package com.job.future.jobservice.service;

import com.job.future.jobservice.model.User;

public interface UserService {
    String signin(String username, String password);

    String signup(User user);
}
