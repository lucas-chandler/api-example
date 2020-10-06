package com.gaseousmammel.service;

import com.gaseousmammel.api.resource.ApiExampleResource;
import com.gaseousmammel.service.accessor.AssessmentResourceModule;
import com.gaseousmammel.service.config.ApiExampleConfig;
import com.gaseousmammel.service.config.ApiExampleConfigParser;
import com.gaseousmammel.service.resource.ApiExampleResourceImpl;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * Top level module for the service.
 */
public class ApiExampleModule extends PrivateModule {

  @Override
  protected void configure() {
    install(new AssessmentResourceModule());

    bind(ApiExampleResource.class).to(ApiExampleResourceImpl.class);

    expose(ApiExampleResource.class);
  }

  @Provides
  @Singleton
  public ApiExampleConfig getConfig() {
    return ApiExampleConfigParser.from(System.getenv());
  }
}
