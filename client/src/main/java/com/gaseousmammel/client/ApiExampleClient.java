package com.gaseousmammel.client;

import com.cerner.beadledom.client.BeadledomClient;
import com.cerner.beadledom.client.BeadledomWebTarget;

public class ApiExampleClient {
  private final HelloWorldResource helloWorldResource;

    ApiExampleClient(BeadledomClient client, ApiExampleConfig config) {
    BeadledomWebTarget target = client.target(config.getBaseUrl());

    helloWorldResource = target.proxy(HelloWorldResource.class);
  }

  public HelloWorldResource helloWorldResource() {
    return helloWorldResource;
  }
}
