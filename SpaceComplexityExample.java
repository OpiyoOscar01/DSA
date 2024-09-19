public class SpaceComplexityExample {

   // Algorithm 1: Using a loop
   public static long sumUsingLoop(int n) {
      long sum = 0;
      for (int i = 1; i <= n; i++) {
         sum += i;
      }
      return sum;
   }

   // Algorithm 2: Using the arithmetic formula
   public static long sumUsingFormula(int n) {
      return (long) n * (n + 1) / 2;
   }

   // Main method to test and demonstrate space complexity
   public static void main(String[] args) {
      int n = 1000000; // Change this value to test with different n

      // Measure memory usage before and after running Algorithm 1
      Runtime runtime = Runtime.getRuntime();
      long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
      sumUsingLoop(n);
      long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
      System.out.println("Memory used by Algorithm 1 (Loop): " + (memoryAfter - memoryBefore) + " bytes");

      // Measure memory usage before and after running Algorithm 2
      memoryBefore = runtime.totalMemory() - runtime.freeMemory();
      sumUsingFormula(n);
      memoryAfter = runtime.totalMemory() - runtime.freeMemory();
      System.out.println("Memory used by Algorithm 2 (Formula): " + (memoryAfter - memoryBefore) + " bytes");
      System.out.println("hello");
   }
}
