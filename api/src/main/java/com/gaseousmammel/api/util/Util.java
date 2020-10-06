package com.gaseousmammel.api.util;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Utility for api model validation.
 */
public class Util {

  private Util() {
    // blank
  }

  /**
   * Groups and counts data sets.
   *
   * @param dataSets to process
   * @return map of data set to count
   */
  public static Map<Set<Integer>, Long> parseCounts(List<Set<Integer>> dataSets) {
    return dataSets.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  /**
   * Returns a new list of data sets that are purged of non-integers.
   *
   * @param dataSets to process
   * @return sanitized list of data sets
   */
  public static List<Set<Integer>> purgeInvalids(List<Set<JsonNode>> dataSets) {
    return dataSets.stream()
        .map(Util::toIntegerSet)
        .collect(Collectors.toList());
  }

  private static Set<Integer> toIntegerSet(Set<JsonNode> strings) {
    return strings.stream()
        .map(Util::toIntegerOrNull)
        .filter(Objects::nonNull)
        .collect(Collectors.toSet());
  }

  private static Integer toIntegerOrNull(JsonNode value) {
    if (value.isNumber()) {
      return value.asInt();
    }
    return null;
  }
}
