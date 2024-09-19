package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting;

public class SelectionSort {
   public static void selectionSort(int[] arr) {
      for (int i = 0; i < arr.length - 1; i++) {
         int min = i;
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
               min = j;
            }
         }
         int temp = arr[min];
         arr[min] = arr[i];
         arr[i] = temp;
      }
   }

   public static void main(String[] args) {
      int[] marks = {34, 78, 10, 78};
      selectionSort(marks);
      for (int i : marks) {
         System.out.print(i + " ");
      }
   }
}
