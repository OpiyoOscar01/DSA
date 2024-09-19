package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams.TermainalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollect {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("John", "Jane", "Johnson", "Pacoming");
      List<String> selected = names
              .stream()
              .filter(name -> name.startsWith("J"))
              .collect(Collectors.toList());
      selected.forEach(System.out::println);


   }
}
