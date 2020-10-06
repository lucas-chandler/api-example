package com.gaseousmammel.service.config;

import com.google.auto.value.AutoValue;

/**
 * Configuration class for the application.
 */
@AutoValue
public abstract class ApiExampleConfig {

  /**
   * The key for the Environment variable that configures the base assessment service url.
   */
  public static final String BASE_ASSESSMENT_URL = "BASE_ASSESSMENT_URL";

  /**
   * Factory method for a builder.
   *
   * @return new builder
   */
  public static Builder builder() {
    return new AutoValue_ApiExampleConfig.Builder();
  }

  /**
   * The value of the base assessment url.
   *
   * @return url
   */
  public abstract String getBaseAssessmentUrl();

  /**
   * Builder class for configuration.
   */
  @AutoValue.Builder
  abstract static class Builder {
    public abstract Builder setBaseAssessmentUrl(String baseAssessmentUrl);
    public abstract ApiExampleConfig build();
  }
}
