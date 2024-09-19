package DataStructure.Linear.Arrays.SingleDimensionArrays.FunctionalStreams.StreamMap;

public class Employee {
   private final String name;
   private final double salary;

   Employee(String name, double salary) {
      this.name = name;
      this.salary = salary;
   }

   public String toString() {
      return "Employee [name=" + name + ", salary=" + salary + "]";
   }
}
