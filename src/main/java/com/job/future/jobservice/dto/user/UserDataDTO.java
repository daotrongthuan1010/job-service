package com.job.future.jobservice.dto.user;

import java.util.List;

import com.job.future.jobservice.model.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
public class UserDataDTO {


    private String username;

    private String email;

    private String password;


    List<Role> roles;

}