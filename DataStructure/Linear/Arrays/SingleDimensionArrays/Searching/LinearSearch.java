package DataStructure.Linear.Arrays.SingleDimensionArrays.Searching;

public class LinearSearch {
   public static int linearSearch(int[] arr, int target) {
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] == target) {
            return i;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      int[] marks = {34, 45, 67, 89, 98, 99};
      System.out.println(linearSearch(marks, 89));

   }
}
