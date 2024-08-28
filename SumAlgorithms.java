public class SumAlgorithms {

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

   // Main method to test and compare time complexities
   public static void main(String[] args) {
      int n = 1000000; // Change this value to test with different n

      long startTime, endTime, duration;

      // Test Algorithm 1
      startTime = System.nanoTime();
      long sum1 = sumUsingLoop(n);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Algorithm 1 (Loop): Sum = " + sum1);
      System.out.println("Time taken for Algorithm 1: " + duration + " nanoseconds");

      // Test Algorithm 2
      startTime = System.nanoTime();
      long sum2 = sumUsingFormula(n);
      endTime = System.nanoTime();
      duration = (endTime - startTime);
      System.out.println("Algorithm 2 (Formula): Sum = " + sum2);
      System.out.println("Time taken for Algorithm 2: " + duration + " nanoseconds");
   }
}
