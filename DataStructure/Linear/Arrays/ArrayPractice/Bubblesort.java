package DataStructure.Linear.Arrays.ArrayPractice;

public class Bubblesort {
   public static void main(String[] args) {

   }

   void bubbleSort(int[] arr) {
      int n = arr.length;
      boolean swapped = false;
      for (int i = 0; i < n - 1; i++) {
         swapped = false;
         for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
               swapped = true;
            }
         }

         if (!swapped) {
            break;
         }
      }
   }
}
