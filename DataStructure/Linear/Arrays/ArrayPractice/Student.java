package DataStructure.Linear.Arrays.ArrayPractice;

public class Student {
   public String name;
   public int newScore;

   public Student(String name, int newScore) {
      this.name = name;
      this.newScore = newScore;
   }

   @Override
   public String toString() {
      return "Student{" +
              "name='" + name + '\'' +
              ", newScore=" + newScore +
              '}';
   }
}
