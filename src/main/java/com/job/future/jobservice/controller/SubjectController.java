package com.job.future.jobservice.controller;

import com.job.future.jobservice.model.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    public ResponseEntity<Subject> getHome() {

        return null;
    }
}
