package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams.TermainalOperations;

import java.util.Arrays;
import java.util.List;

public class StreamCount {
   public static void main(String[] args) {
      List<String> fruits = Arrays.asList("Apple", "Orange", "Watermelon");
      System.out.println(fruits.stream().count());

   }
}
