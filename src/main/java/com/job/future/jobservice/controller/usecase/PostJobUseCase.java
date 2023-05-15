package com.job.future.jobservice.controller.usecase;

import com.job.future.jobservice.api.request.PostJobApiRequest;
import com.job.future.jobservice.dto.PostJobDTO;
import com.job.future.jobservice.exception.ServiceException;
import com.job.future.jobservice.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PostJobUseCase {


    private final JobService jobService;

    public void execute(PostJobApiRequest apiRequest) throws ServiceException {

      log.info(apiRequest.toString());

        jobService.save(PostJobDTO.builder()
                .code(apiRequest.getCode())
                .name(apiRequest.getName())
                .status(Integer.parseInt(apiRequest.getStatus()))
                .salaryAvg(apiRequest.getSalaryAvg())
                .idCategoryJob(apiRequest.getIdCategoryJob())
                .idJobPath(apiRequest.getIdJobPath())
                .build());

    }






}
