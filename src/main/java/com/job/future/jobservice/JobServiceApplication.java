package com.job.future.jobservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JobServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(JobServiceApplication.class, args);
  }

}
