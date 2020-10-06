package com.gaseousmammel.api.resource;

import com.cerner.beadledom.jaxrs.GenericResponse;
import com.gaseousmammel.api.model.DataSetCountDto;
import com.gaseousmammel.api.model.DataSetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Api(value = "/test")
@Path("/test")
public interface ApiExampleResource {

  @ApiOperation(
      value = "Returns the counts of values in the data",
      response = DataSetCountDto.class)
  @ApiResponse(code = 200, message = "Success")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  GenericResponse<DataSetCountDto> countDataSets(DataSetDto dataSetDto);

  @ApiOperation(
      value = "Retrieves sanitized data from the backing endpoint.",
      response = DataSetDto.class)
  @ApiResponse(code = 200, message = "Success")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  GenericResponse<DataSetDto> validateDataSets(
      @QueryParam("seed") Long seed,
      @QueryParam("count") Long count,
      @QueryParam("limit") Long limit) throws IOException, InterruptedException;
}
