package DataStructure.Linear.Arrays.ArrayPractice;

public class SumElementsInArray {
   public static void main(String[] args) {
      int[] marks = {78, 90, 99, 100};
      int sum = 0;
      for (int value : marks) {
         sum += value;
      }
      System.out.println(sum);
   }
}
