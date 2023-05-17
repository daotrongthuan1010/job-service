package com.job.future.jobservice.service.serviceIpm;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@RequiredArgsConstructor
public class ProvinceService {

  private final RestTemplate restTemplate;

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
