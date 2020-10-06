package com.gaseousmammel.service.resource;

import com.cerner.beadledom.jaxrs.GenericResponse;
import com.cerner.beadledom.jaxrs.GenericResponses;
import com.gaseousmammel.api.model.DataSetCountDto;
import com.gaseousmammel.api.model.DataSetDto;
import com.gaseousmammel.api.resource.ApiExampleResource;
import com.gaseousmammel.service.accessor.AssessmentDao;
import java.io.IOException;
import javax.inject.Inject;

/**
 * Server Implementation of {@link ApiExampleResource}.
 */
public class ApiExampleResourceImpl implements ApiExampleResource {

  private AssessmentDao assessmentDao;

  /**
   * Injectable constructor.
   *
   * @param assessmentDao access object for assessment data
   */
  @Inject
  public ApiExampleResourceImpl(AssessmentDao assessmentDao) {
    this.assessmentDao = assessmentDao;
  }

  @Override
  public GenericResponse<DataSetCountDto> countDataSets(DataSetDto dataSetDto) {
    return GenericResponses
        .ok(DataSetCountDto.create(dataSetDto.countByDataSet()))
        .build();
  }

  @Override
  public GenericResponse<DataSetDto> validateDataSets(Long seed, Long count, Long limit)
      throws IOException, InterruptedException {

    return GenericResponses.ok(assessmentDao.getData(seed, count, limit)).build();
  }
}
