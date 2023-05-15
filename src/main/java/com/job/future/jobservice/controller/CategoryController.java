package com.job.future.jobservice.controller;

import com.job.future.jobservice.model.JobCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    public ResponseEntity<JobCategory> home(){
        return null;
    }

}
