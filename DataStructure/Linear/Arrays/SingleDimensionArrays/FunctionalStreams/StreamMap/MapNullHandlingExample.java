package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams.StreamMap;

import java.util.Arrays;
import java.util.List;

public class MapNullHandlingExample {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("John", "Paul", "Mary", null);

      names
              .stream()
              .map(name -> name == null ? "Unknown" : name)
              .forEach(System.out::println);

   }
}
