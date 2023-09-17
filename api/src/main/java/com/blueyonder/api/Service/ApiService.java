package com.blueyonder.api.Service;

import com.blueyonder.api.Response.ApiResponse;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
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
        return restTemplate.getForObject(apiUrl, ApiResponse.class);
    }
}

