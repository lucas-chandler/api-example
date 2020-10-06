package com.gaseousmammel.service.config;

import java.util.Map;
import java.util.Objects;

/**
 * Utility for parsing configuration from a map of values
 */
public class ApiExampleConfigParser {

  private ApiExampleConfigParser() {
    // blank
  }

  /**
   * Parses a config object from the provided map.
   *
   * @param env map of environment variables
   * @return new configuration object
   */
  public static ApiExampleConfig from(Map<String, String> env) {
    return ApiExampleConfig.builder()
        .setBaseAssessmentUrl(getRequired(env, ApiExampleConfig.BASE_ASSESSMENT_URL))
        .build();
  }

  private static String getRequired(Map<String, String> env, String key) {
    // should check for empty values as well
    return Objects.requireNonNull(String.valueOf(env.get(key)),
        () -> "missing value for " + key);
  }
}
