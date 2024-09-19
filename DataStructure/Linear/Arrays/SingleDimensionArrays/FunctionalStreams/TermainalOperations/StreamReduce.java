package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams.TermainalOperations;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {
   public static void main(String[] args) {
      List<String> sentence = Arrays.asList("I love to ", "Program in", " Java", " Language");

      String result = sentence.stream().reduce("", (a, b) -> a + b);
      System.out.println(result);

      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
      System.out.println(numbers
              .stream()
              .reduce(0, (a, b) -> (a + b)));

   }
}
