package com.job.future.jobservice.service;

import com.job.future.jobservice.dto.PostJobDTO;
import com.job.future.jobservice.exception.ServiceException;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface JobService {

  void save(PostJobDTO postJobDTO) throws ServiceException;

}
