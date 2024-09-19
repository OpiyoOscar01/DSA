package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams;

import java.util.Arrays;
import java.util.List;

public class StreamSort {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("Jmaes", "Mark", "Mary", "Johnss", "Paul", "Peter", "Steve");
      names.stream().sorted().forEach(System.out::println);
   }

}
