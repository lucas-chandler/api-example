package com.gaseousmammel.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.Map;
import java.util.Set;

/**
 *
 */
@AutoValue
public abstract class DataSetCountDto {

  @JsonCreator
  public static DataSetCountDto create(
      @JsonProperty("counts") Map<Set<Integer>, Long> countByDataSet) {
    return new AutoValue_DataSetCountDto(countByDataSet);
  }

  @JsonProperty("counts")
  public abstract Map<Set<Integer>, Long> countByDataSet();
}
