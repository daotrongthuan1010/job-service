package com.job.future.jobservice.controller;

import com.job.future.jobservice.api.request.PostJobApiRequest;
import com.job.future.jobservice.controller.usecase.PostProvinceUseCase;
import com.job.future.jobservice.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/province")
public class ProvinceController {

    private final PostProvinceUseCase postProvinceUseCase;

    @GetMapping("/get_all")
    public void index() throws ServiceException {
        postProvinceUseCase.execute();
    }
}
