package DataStructure.Linear.Arrays.ArrayPractice;

public class BaseAddressSimulation {
   public static void main(String[] args) {
      int baseAdress = 1000;
      int size = 4;
      int[] marks = new int[6];
      for (int i = 0; i < 6; i++) {
         marks[i] = i + 1;
      }
      System.out.println("Simulated Base Address Representation.\n" +
              "Marrks||BasesAdress");
      for (int i = 0; i < 6; i++) {
         int simulatedBaseValue = baseAdress + marks[i] * size;
         System.out.println(marks[i] + "||" + simulatedBaseValue);

      }
   }


}
