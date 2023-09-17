package com.blueyonder.api;

import com.blueyonder.api.Controller.ApiController;
import com.blueyonder.api.Exception.ExternalApiException;
import com.blueyonder.api.Response.ApiResponse;
import com.blueyonder.api.Service.ApiService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class ApiControllerTests {

    @Mock
    private ApiService apiService;

    @InjectMocks
    private ApiController apiController;

    private MockMvc mockMvc;

    public ApiControllerTests() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    public void testGetApiEntries() throws Exception {
        ApiResponse mockResponse = new ApiResponse();
        mockResponse.setCount(1425);

        when(apiService.fetchApiEntries()).thenReturn(mockResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/entries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(1425)));
    }

    @Test
    public void testGetApiEntriesError() throws Exception {
        when(apiService.fetchApiEntries()).thenThrow(new ExternalApiException("Error message"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/entries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

}