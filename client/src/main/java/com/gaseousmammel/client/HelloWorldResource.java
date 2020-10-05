package com.gaseousmammel.client;

import com.gaseousmammel.api.model.HelloWorldDto;
import com.cerner.beadledom.jaxrs.GenericResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public interface HelloWorldResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  GenericResponse<HelloWorldDto> getHelloWorld();
}
