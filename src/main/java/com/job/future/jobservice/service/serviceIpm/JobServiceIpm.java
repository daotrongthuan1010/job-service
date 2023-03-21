package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.dto.PostJobDTO;
import com.job.future.jobservice.exception.ServiceException;
import com.job.future.jobservice.model.Job;
import com.job.future.jobservice.model.JobCategory;
import com.job.future.jobservice.model.JobPath;
import com.job.future.jobservice.repository.JobCategoryRepository;
import com.job.future.jobservice.repository.JobCustomRepository;
import com.job.future.jobservice.repository.JobPathRepository;
import com.job.future.jobservice.repository.JobRepository;
import com.job.future.jobservice.service.JobService;
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


  private final JobRepository jobRepository;


  private final JobCustomRepository jobCustomRepository;

  private final JobCategoryRepository jobCategoryRepository;

  private final JobPathRepository jobPathRepository;


  @Override
  public void save(PostJobDTO postJobDTO) throws ServiceException {
    JobCategory jobCategory = jobCategoryRepository.findById(postJobDTO.getIdCategoryJob())
        .orElseThrow(() -> new ServiceException("NOT_FOUND"));

    JobPath jobPath = jobPathRepository.findById(postJobDTO.getIdJobPath())
        .orElseThrow(() -> new ServiceException("NOT_FOUND"));

    Job job = Job.builder()
        .code(postJobDTO.getCode())
        .name(postJobDTO.getName())
        .salaryAvg(postJobDTO.getSalaryAvg())
        .jobPath(jobPath)
        .jobCategory(jobCategory)
        .build();

    jobRepository.save(job);

  }
}