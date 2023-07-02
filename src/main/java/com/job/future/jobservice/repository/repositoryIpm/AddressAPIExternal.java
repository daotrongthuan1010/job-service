package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.address.AddressDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressAPIExternal {

    private final RestTemplate restTemplate;

    public ResponseEntity<List<AddressDTO>> getAddress(String q) {
        // Disable SSL certificate verification
        disableSslVerification();

        String url = "https://provinces.open-api.vn/api/d/search";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("q", q);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer");

        ResponseEntity<AddressDTO[]> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
                new HttpEntity<>(headers), AddressDTO[].class);

        return ResponseEntity.ok(List.of(responseEntity.getBody()));
    }

    private void disableSslVerification() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}