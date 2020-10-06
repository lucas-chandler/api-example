package com.gaseousmammel.service.accessor;

import com.gaseousmammel.api.model.DataSetDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AssessmentResource {

  @GET("/data")
  Call<DataSetDto> getData(
      @Query("seed") String seed,
      @Query("count") Long count,
      @Query("length") Long length);
}
