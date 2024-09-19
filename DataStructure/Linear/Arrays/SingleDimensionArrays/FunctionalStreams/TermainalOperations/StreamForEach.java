package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams.TermainalOperations;

import java.util.Arrays;
import java.util.List;

public class StreamForEach {
   public static void main(String[] args) {
      List<String> orders = Arrays.asList("A", "B", "C", "D", "E", "F");
      orders.stream().forEach(System.out::println);
   }
}
