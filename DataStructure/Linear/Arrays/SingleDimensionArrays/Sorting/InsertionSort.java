package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting;

public class InsertionSort {
   public static void insertionSort(int[] arr) {
      for (int i = 1; i < arr.length; i++) {
         int key = arr[i];
         int j = i - 1;
         while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
         }
         arr[j + 1] = key;
      }
   }

   public static void main(String[] args) {
      int[] scores = {34, 10, 8, 3, 89, 45};
      System.out.println("Before sorting:");
      for (int i = 0; i < scores.length; i++) {
         System.out.print(scores[i] + " ");
      }
      System.out.println();
      insertionSort(scores);
   }

}
