package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.repository.JobCustomRepository;
import com.job.future.jobservice.repository.JobRepository;
import com.job.future.jobservice.service.JobService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@RequiredArgsConstructor
public class JobServiceIpm implements JobService {

  private JobRepository jobRepository;

  private JobCustomRepository jobCustomRepository;




}
