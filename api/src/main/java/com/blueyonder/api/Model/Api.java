package com.blueyonder.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Api {

    @JsonProperty("API")
    private String API;

    @JsonProperty("Description")
    private String Description;

    @JsonProperty("Auth")
    private String Auth;

    @JsonProperty("HTTPS")
    private boolean HTTPS;

    @JsonProperty("Cors")
    private String Cors;

    @JsonProperty("Link")
    private String Link;

    @JsonProperty("Category")
    private String Category;
}




