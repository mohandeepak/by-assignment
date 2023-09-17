package com.blueyonder.api.Controller;

import com.blueyonder.api.Exception.ExternalApiException;
import com.blueyonder.api.Response.ApiResponse;
import com.blueyonder.api.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/entries")
    public ResponseEntity<?> getApiEntries() {
        try {
            ApiResponse apiResponse = apiService.fetchApiEntries();
            return ResponseEntity.ok(apiResponse);
        } catch (ExternalApiException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (RestClientException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service Unavailable");
        }
    }
}