package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams;

import java.util.Arrays;
import java.util.List;

public class StreamIntro {
   public static void main(String[] args) {
      String[] names = {"Mark", "Alex", "Joseph", "Kelly", "Steve"};
      List<String> students = Arrays.asList(names);
      students.forEach(System.out::println);//forEach() methid is a terminal operation that prints each elemnent

   }
}
