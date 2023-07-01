package com.job.future.jobservice;

import com.job.future.jobservice.model.Role;
import com.job.future.jobservice.model.User;
import com.job.future.jobservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
@RequiredArgsConstructor
public class JwtAuthServiceApp implements CommandLineRunner {

    final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthServiceApp.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {


        userService.signup(User.builder()
                .username("admin")
                .password("admin")
                .email("admin@gmail.com")
                .roles(new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN)))
                .build());

        userService.signup(User.builder()
                .username("client")
                .password("client")
                .email("client.com")
                .roles(new ArrayList<>(Arrays.asList(Role.ROLE_CLIENT)))
                .build());

    }

}