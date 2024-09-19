package DataStructure.Linear.Arrays.ArrayPractice;

public class Person {
   protected String name;
   protected int score;

   public Person(String name, int score) {
      this.name = name;
      this.score = score;
   }

   @Override
   public String toString() {
      return "Person{" +
              "name='" + name + '\'' +
              ", score=" + score +
              '}';
   }
}
