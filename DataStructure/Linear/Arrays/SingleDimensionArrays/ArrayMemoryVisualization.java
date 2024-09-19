package DataStructure.Linear.Arrays.SingleDimensionArrays;

public class ArrayMemoryVisualization {


   public static void main(String[] args) {
      int size = 5;
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
         array[i] = i + 1;
      }
      int baseAddress = 1000;
      int elementSize = 4;
      System.out.println("Index | Value | Simulated Memory Address");
      System.out.println("----------------------------------------");
      for (int i = 0; i < size; i++) {
         int simulatedAddress = baseAddress + (i * elementSize);
         System.out.printf("%d | %d | %d%n", i, array[i], simulatedAddress);

      }

   }
}

