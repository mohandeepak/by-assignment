package com.blueyonder.api.Response;

import com.blueyonder.api.Model.Api;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponse {

    @JsonProperty("count")
    private int count;

    @JsonProperty("entries")
    private List<Api> entries;
}
