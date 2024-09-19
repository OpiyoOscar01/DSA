package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting.SortingExercises;

public class MergeSortStrings {

   //  Implement Merge Sort for an array of strings where the strings are sorted lexicographically
   public static void mergeSort(String[] arr, int left, int right) {
      if (left < right) {
         int mid = (left + right) / 2;

         mergeSort(arr, left, mid);
         mergeSort(arr, mid + 1, right);

         merge(arr, left, mid, right);
      }
   }

   // Merge two halves
   public static void merge(String[] arr, int left, int mid, int right) {
      int n1 = mid - left + 1;
      int n2 = right - mid;

      String[] L = new String[n1];
      String[] R = new String[n2];

      System.arraycopy(arr, left + 0, L, 0, n1);
      for (int j = 0; j < n2; j++)
         R[j] = arr[mid + 1 + j];

      int i = 0, j = 0, k = left;

      while (i < n1 && j < n2) {
         if (L[i].compareTo(R[j]) <= 0) {
            arr[k] = L[i];
            i++;
         } else {
            arr[k] = R[j];
            j++;
         }
         k++;
      }

      while (i < n1) {
         arr[k] = L[i];
         i++;
         k++;
      }

      while (j < n2) {
         arr[k] = R[j];
         j++;
         k++;
      }
   }

   public static void main(String[] args) {
      // Sample array of strings
      String[] arr = {"banana", "apple", "grape", "cherry", "elderberry"};

      // Perform merge sort
      mergeSort(arr, 0, arr.length - 1);

      // Display the sorted array
      for (String str : arr) {
         System.out.print(str + " ");
      }
   }
}

