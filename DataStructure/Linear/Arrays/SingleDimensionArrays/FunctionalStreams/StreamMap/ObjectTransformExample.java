package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams.StreamMap;

import java.util.Arrays;
import java.util.List;

public class ObjectTransformExample {
   public static void main(String[] args) {
      List<Person> people = Arrays.asList(
              new Person("Oscar", 23),
              new Person("Mike", 13),
              new Person("Jobs", 20)
      );
      people.stream()
              .map(person -> new Employee(person.name, person.age * 1000))
              .forEach(System.out::println);
   }

}
