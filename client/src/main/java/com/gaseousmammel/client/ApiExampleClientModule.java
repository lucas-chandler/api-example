package com.gaseousmammel.client;

import com.cerner.beadledom.client.BeadledomClient;
import com.cerner.beadledom.client.BeadledomClientConfiguration;
import com.cerner.beadledom.client.BeadledomClientModule;
import com.cerner.beadledom.client.BeadledomWebTarget;
import com.cerner.beadledom.client.jackson.ObjectMapperClientFeatureModule;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import javax.inject.Singleton;

public class ApiExampleClientModule extends AbstractModule {

  @Override
  public void configure() {
    requireBinding(ApiExampleConfig.class);

    install(BeadledomClientModule.with(ApiExampleClientFeature.class));
    install(ObjectMapperClientFeatureModule.with(ApiExampleClientFeature.class));
  }

  @Provides
  @Singleton
  @ApiExampleClientFeature
  public BeadledomClientConfiguration provideClientConfiguration() {
    return BeadledomClientConfiguration.builder().build();
  }

  @Provides
  @Singleton
  public ApiExampleClient provideApiExampleClient(@ApiExampleClientFeature BeadledomClient client,
      ApiExampleConfig config) {
    return new ApiExampleClient(client, config);
  }
}
