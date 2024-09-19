package DataStructure.Linear.Arrays.ArrayPractice;

import java.util.Arrays;
import java.util.List;

public class StudentPersonMapping {
   public static void main(String[] args) {
      List<Person> personList = Arrays.asList(
              new Person("Oscar", 23),
              new Person("Mike", 34),
              new Person("Stella", 24)
      );
      personList.stream().map(person -> new Student(person.name, person.score))
              .forEach(System.out::println);

   }
}
