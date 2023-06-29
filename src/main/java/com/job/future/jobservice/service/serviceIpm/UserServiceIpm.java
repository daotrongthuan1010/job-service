package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.dto.user.CreateAccountDTO;
import com.job.future.jobservice.model.User;
import com.job.future.jobservice.model.Users;
import com.job.future.jobservice.repository.UserRepository;
import com.job.future.jobservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceIpm implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createUser(CreateAccountDTO accountDTO) {

        String encodedPassword = passwordEncoder.encode(accountDTO.getPassword());

        User users = User.builder().username(accountDTO.getUsername())
                .password(encodedPassword)
                .numberPhone(accountDTO.getNumberPhone())
                .email(accountDTO.getEmail())
                .build();

        userRepository.save(users);

    }

    @Override
    public void deleteUser(String username) {

    }


}
