package com.blueyonder.api.Controller;

import com.blueyonder.api.Response.ApiResponse;
import com.blueyonder.api.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/api/entries")
    public ApiResponse getApiEntries() {
        return apiService.fetchApiEntries();
    }
}