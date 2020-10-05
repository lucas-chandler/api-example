package com.gaseousmammel.service.resource;

import com.gaseousmammel.api.model.HelloWorldDto;
import com.cerner.beadledom.jaxrs.GenericResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value = "/hello", description = "Retrieve hello world data")
@Path("/hello")
public class HelloWorldResource {

  @ApiOperation(
      value = "Retrieves hello world data.",
      response = HelloWorldDto.class)
  @ApiResponse(code = 200, message = "Success")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public GenericResponse<HelloWorldDto> getHelloWorld() {
    return GenericResponses
        .ok(HelloWorldDto.create("Beadledom", "Hello World!"))
        .build();
  }
}
