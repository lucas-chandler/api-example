package com.gaseousmammel.client;

public class ApiExampleConfig {
  private final String baseUrl;

  // If OAuth is being used this is a natural place to encapsulate the values
  public ApiExampleConfig(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String getBaseUrl() {
    return baseUrl;
  }
}
