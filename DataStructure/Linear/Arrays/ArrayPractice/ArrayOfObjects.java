package DataStructure.Linear.Arrays.ArrayPractice;

import java.util.Scanner;

public class ArrayOfObjects {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number of people: ");
      Person[] people = new Person[sc.nextInt()];
      for (int i = 0; i < people.length; i++) {
         System.out.println("Enter the name: ");
         String name = sc.next();
         System.out.println("Enter the score: ");
         int score = sc.nextInt();
         people[i] = new Person(name, score);
      }
      for (Person person : people) {
         System.out.println(person);
      }
   }
}
