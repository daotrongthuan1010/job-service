package com.job.future.jobservice.service;

import com.job.future.jobservice.exception.ServiceException;
import com.job.future.jobservice.model.Job;
import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface JobService {

  void save(PostJobDTO postJobDTO) throws ServiceException;

  List<Job> findAll();

}
