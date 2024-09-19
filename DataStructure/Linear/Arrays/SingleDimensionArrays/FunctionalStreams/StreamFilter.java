package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams;

import java.util.Arrays;
import java.util.List;

public class StreamFilter {
   public static void main(String[] args) {
      List<String> names = Arrays.asList("AJmess", "John", "Kelvin", "John", "Markline", "Martha", "Steve");

      names
              .stream()
              .filter(name -> name.contains("A".toLowerCase()) || name.startsWith("A"))
              .forEach(System.out::println);

   }
}
