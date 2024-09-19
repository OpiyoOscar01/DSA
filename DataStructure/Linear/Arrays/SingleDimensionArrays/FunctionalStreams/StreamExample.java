package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
   public static void main(String[] args) {
      String[] names = {"James", "Mary", "Lisa", "Mark", "John", "James", "Steve", "Mikel"};
      List<String> studentNames = Arrays.asList(names);

      List<String> result = studentNames
              .stream()
              .filter(student -> student.contains("J"))
              .map(String::toUpperCase)
              .sorted()
              .collect(Collectors.toList());

      for (String s : result) {
         System.out.println(s);
      }


      Integer[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      List<Integer> result1 = Arrays.asList(points);
      List<Integer> filteredRsesult = result1
              .stream()
              .filter(pt -> pt > 5)
              .collect(Collectors.toList());

      for (Integer i : filteredRsesult) {
         System.out.println(i);
      }


   }
}
