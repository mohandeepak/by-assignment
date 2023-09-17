package com.blueyonder.api.Service;

import com.blueyonder.api.Exception.ExternalApiException;
import com.blueyonder.api.Response.ApiResponse;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final String apiUrl = "https://api.publicapis.org/entries";
    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("apiEntriesCache")
    public ApiResponse fetchApiEntries() {
        try {
            ResponseEntity<ApiResponse> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    ApiResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
               // handle non 200 response status
                throw new ExternalApiException("External API returned an error: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new ExternalApiException("Error while fetching data from the external API", e);
        }
    }
}
