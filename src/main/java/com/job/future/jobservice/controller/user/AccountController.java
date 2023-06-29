package com.job.future.jobservice.controller.user;

import com.job.future.jobservice.api.request.User.CreateAccountApiRequest;
import com.job.future.jobservice.api.request.User.LoginAccountApiRequest;
import com.job.future.jobservice.api.response.user.LoginAccountApiResponse;
import com.job.future.jobservice.dto.user.CreateAccountDTO;
import com.job.future.jobservice.model.Users;
import com.job.future.jobservice.service.UserService;
import com.job.future.jobservice.service.serviceIpm.UserDetailsServiceIpm;
import com.job.future.jobservice.utils.jwtconfig.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class AccountController {

    private final Validator validator;

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final UserDetailsServiceIpm serviceIpm;

    private final JwtUtils jwtUtils;

    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @PostMapping("/create")
    public void createAccount(@RequestBody  CreateAccountApiRequest request) {

        logger.info("Username: {}", request.getUsername());

        userService.createUser(
                CreateAccountDTO.builder()
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .fullName(request.getFullName())
                        .numberPhone(request.getNumberPhone())
                        .email(request.getEmail())
                        .build());

    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginAccountApiRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateTokenLogin(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }


}
