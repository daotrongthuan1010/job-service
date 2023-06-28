package com.job.future.jobservice.service;

import com.job.future.jobservice.dto.user.CreateAccountDTO;
import com.job.future.jobservice.model.Users;

public interface UserService {
    void createUser(CreateAccountDTO accountDTO);

    void deleteUser(String username);
}
