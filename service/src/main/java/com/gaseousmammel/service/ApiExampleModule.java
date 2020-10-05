package com.gaseousmammel.service;

import com.gaseousmammel.service.resource.HelloWorldResource;
import com.google.inject.PrivateModule;

public class ApiExampleModule extends PrivateModule {

  protected void configure() {
    bind(HelloWorldResource.class);

    // Note: If any clients will be used that directly provide injection of JAX-RS interfaces, then
    // they should be installed in this private module to avoid registering client JAX-RS resources
    // with the server.
    //
    // It's also worth noting that using any multibinders or optional bindings across both private
    // and normal Guice modules is not a supported feature of Guice. Therefore this module should be
    // your only private module, if needed at all. Prefer standard Guice modules for installing
    // Beadledom clients if possible.
    //
    // The Correlation ID header name for clients could also be configured/overridden here if this
    // is the only PrivateModule that is used.

    expose(HelloWorldResource.class);
  }
}
