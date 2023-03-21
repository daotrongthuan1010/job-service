package com.job.future.jobservice.config.interceptor;

import java.io.IOException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public class MyCustomInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
    // Thêm header cho request
    request.getHeaders().add("User-Agent", "MyApp");
    // Gửi request và nhận response
    ClientHttpResponse response = execution.execute(request, body);
    // Xử lý response nếu cần
    if (response.getStatusCode() == HttpStatus.OK) {
      System.out.println("Request successful");
    }
    return response;
  }


}
