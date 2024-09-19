package DataStructure.Linear.Arrays.SingleDimensionArrays;

public class SingleDimensionArray {
   public static void main(String[] args) {

      int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      for (int i = 0; i < myArray.length; i++) {
         System.out.println(myArray[i]);
      }
      int[][] arr = {
              {1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}
      };
      System.out.println(arr.length);
      System.out.println(arr[1][1]);

      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }

      String[] names = {"Mark", "John", "Jane"};
      for (String name : names) {
         System.out.println(name);
      }

   }
}
