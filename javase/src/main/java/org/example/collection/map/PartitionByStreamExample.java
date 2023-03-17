package org.example.collection.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuliangqi
 * @date 2023/3/17 17:06
 */
public class PartitionByStreamExample {
  private static final List<Integer> OLD_LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

  public static void main(String[] args) {
    Map<Boolean, List<Integer>> map =
        OLD_LIST.stream().collect(Collectors.partitioningBy(i -> i > 3));
    System.out.println(map);
  }
}
