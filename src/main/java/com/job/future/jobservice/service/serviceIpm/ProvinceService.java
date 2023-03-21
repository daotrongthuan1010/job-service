package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.dto.ProvinceDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class ProvinceService {
  @Autowired
  private RestTemplate restTemplate;

  public List<ProvinceDTO> getProvinces() {
    ResponseEntity<ProvinceDTO[]>
        response = restTemplate.getForEntity("https://provinces.open-api.vn/api", ProvinceDTO[].class);
    if (response.getStatusCode() == HttpStatus.OK) {
      return Arrays.asList(response.getBody());
    } else {
      // handle error
      throw new RuntimeException("Failed to get provinces: " + response.getStatusCode());
    }
  }
}