package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.repository.UserRepository;
import com.job.future.jobservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@RequiredArgsConstructor
public class UserServiceIpm implements UserService {

  private final UserRepository userRepository;
}
