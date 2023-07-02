package com.job.future.jobservice.controller.user;

import com.job.future.jobservice.dto.user.UserDataDTO;
import com.job.future.jobservice.model.User;
import com.job.future.jobservice.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @PostMapping("/signin")
    public String login(@RequestBody UserDataDTO userDataDTO) {
        return userService.signin(userDataDTO.getUsername(), userDataDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup( @RequestBody UserDataDTO user) {
        System.out.println("a");
        return userService.signup(user);
    }


}