package com.job.future.jobservice.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Getter
@Builder
public class ProvinceDTO {
  private String code;
  private String name;
  private String phone;
  private String province_type;



  // constructors, getters, setters
}
