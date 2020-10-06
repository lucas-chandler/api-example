package com.gaseousmammel.service.accessor;

import com.gaseousmammel.api.model.DataSetDto;
import java.io.IOException;
import javax.inject.Inject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Data access object for the assessment service data.
 */
public class AssessmentDao {

  public static final int DEFAULT_RETRY_ATTEMPTS = 3;
  public static final int DEFAULT_RETRY_DELAY_MILLIS = 100;

  private final AssessmentResource assessmentResource;

  /**
   * Injectable constructor.
   *
   * @param assessmentResource assessment service resource
   */
  @Inject
  public AssessmentDao(AssessmentResource assessmentResource) {
    this.assessmentResource = assessmentResource;
  }

  /**
   * Retrieves data from the assessment service.
   *
   * @param seed seeds randomization in the assessment service
   * @param count the number of data sets to return
   * @param length the length of the data sets returned
   * @return DataSetDto
   * @throws IOException when unable to retrieve data from the service
   * @throws InterruptedException when interrupted
   */
  public DataSetDto getData(Long seed, Long count, Long length)
      throws IOException, InterruptedException {
    Call<DataSetDto> call = assessmentResource.getData(String.valueOf(seed), count, length);

    return doCall(call, 1);
  }

  // This retry logic should probably be isolated to made reusable or refactored to be an
  // Interceptor on the OKClient.
  private DataSetDto doCall(Call<DataSetDto> call, int attempt)
      throws IOException, InterruptedException {

    Response<DataSetDto> response = call.execute();

    if (response.isSuccessful()) {
      return response.body();
    }

    if (attempt >= DEFAULT_RETRY_ATTEMPTS) {
      ResponseBody responseBody = response.errorBody();
      String errorString  = responseBody == null ? "empty error body" : responseBody.string();
      throw new IOException(errorString);
    }

    Thread.sleep(DEFAULT_RETRY_DELAY_MILLIS);

    return doCall(call.clone(), attempt + 1);
  }
}
