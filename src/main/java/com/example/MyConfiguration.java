package com.example;

import io.dropwizard.core.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;

public class MyConfiguration extends Configuration {
    @NotEmpty
    private String databaseUrl;

    @JsonProperty
    public String getDatabaseUrl() {
        return databaseUrl;
    }

    @JsonProperty
    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }
}
