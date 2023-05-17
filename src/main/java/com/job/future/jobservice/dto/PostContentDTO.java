package com.job.future.jobservice.dto;

import com.job.future.jobservice.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class PostContentDTO {

    private String code;

    private String title;

    private String content;

    private Long views;

    private LocalDateTime createdAt;

    private Double ratingAvg;


}
