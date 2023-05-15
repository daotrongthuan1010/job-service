package com.job.future.jobservice.controller.usecase;

import com.job.future.jobservice.api.response.ProvinceApiResponse;
import com.job.future.jobservice.dto.ProvinceDTO;
import com.job.future.jobservice.service.serviceIpm.ProvinceService;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@RequiredArgsConstructor
public class PostProvinceUseCase {

    private final ProvinceService provinceService;

    public void execute() {

        List<ProvinceDTO> provinceDTOs = provinceService.getProvinces();

        List<ProvinceApiResponse> responseDataList = provinceDTOs.stream()
                .map(dto -> ProvinceApiResponse.builder()
                        .code(dto.getCode())
                        .name(dto.getName())
                        .phoneCode(dto.getPhone())
                        .devision_type(dto.getProvince_type())
                        // add more fields as needed
                        .build())
                .collect(Collectors.toList());


    }

}
