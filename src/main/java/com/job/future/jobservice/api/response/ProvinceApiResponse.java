package com.job.future.jobservice.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Getter
@Builder
@AllArgsConstructor
public class ProvinceApiResponse {

  private String name;

  private String code;

  private String devision_type;

  private String phoneCode;

}
