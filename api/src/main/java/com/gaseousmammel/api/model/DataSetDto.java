package com.gaseousmammel.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.gaseousmammel.api.util.Util;
import com.google.auto.value.AutoValue;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents a list of data sets.
 */
@AutoValue
public abstract class DataSetDto {

  /**
   * Factory constructor method.
   *
   * @param dataSetList list of data sets
   * @return sanitized data set dto
   */
  @JsonCreator
  public static DataSetDto create(@JsonProperty("data") List<Set<JsonNode>> dataSetList) {

    return new AutoValue_DataSetDto(Util.purgeInvalids(dataSetList));
  }

  /**
   * The list of data sets.
   *
   * @return list of data sets
   */
  @JsonProperty("data")
  public abstract List<Set<Integer>> data();

  /**
   * Groups and counts the data sets.
   *
   * @return map of data set to counts
   */
  public Map<Set<Integer>, Long> countByDataSet() {
    return Util.parseCounts(data());
  }
}
