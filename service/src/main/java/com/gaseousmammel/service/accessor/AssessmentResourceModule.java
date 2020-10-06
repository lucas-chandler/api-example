package com.gaseousmammel.service.accessor;

import com.gaseousmammel.service.config.ApiExampleConfig;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Module to configure Assessment Service resource.
 */
public class AssessmentResourceModule extends AbstractModule {

  @Override
  public void configure() {
    requireBinding(ApiExampleConfig.class);
  }

  @Provides
  @Singleton
  public AssessmentResource getClient(ApiExampleConfig config) {
    return new Retrofit.Builder()
        .baseUrl(config.getBaseAssessmentUrl())
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
        .create(AssessmentResource.class);
  }
}
