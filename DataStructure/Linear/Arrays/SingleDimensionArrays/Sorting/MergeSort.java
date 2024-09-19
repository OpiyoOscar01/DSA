package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting;

public class MergeSort {

   // Method to merge two subarrays
   public static void merge(int[] arr, int left, int mid, int right) {
      // Find the sizes of the two subarrays
      int n1 = mid - left + 1;
      int n2 = right - mid;

      // Create temporary arrays for the two halves
      int[] L = new int[n1];
      int[] R = new int[n2];

      // Copy data into temporary arrays
      System.arraycopy(arr, left + 0, L, 0, n1);
      for (int j = 0; j < n2; j++) {
         R[j] = arr[mid + 1 + j];
      }

      // Merge the temporary arrays back into the original array
      int i = 0, j = 0, k = left;

      // Compare elements from both subarrays and place them in order
      while (i < n1 && j < n2) {
         if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
         } else {
            arr[k] = R[j];
            j++;
         }
         k++;
      }

      // Copy remaining elements of L[], if any
      while (i < n1) {
         arr[k] = L[i];
         i++;
         k++;
      }

      // Copy remaining elements of R[], if any
      while (j < n2) {
         arr[k] = R[j];
         j++;
         k++;
      }
   }

   // Method to sort the array using merge sort
   public static void sort(int[] arr, int left, int right) {
      if (left < right) {
         // Find the middle point
         int mid = (left + right) / 2;

         // Recursively sort both halves
         sort(arr, left, mid);
         sort(arr, mid + 1, right);

         // Merge the sorted halves
         merge(arr, left, mid, right);
      }
   }

   // Main method to test the sorting
   public static void main(String[] args) {
      // Sample array to be sorted
      int[] arr = {12, 11, 13, 5, 6, 7};

      // Print the array before sorting
      System.out.println("Array before sorting:");
      for (int num : arr) {
         System.out.print(num + " ");
      }
      System.out.println();

      // Perform merge sort
      sort(arr, 0, arr.length - 1);

      // Print the sorted array
      System.out.println("Array after sorting:");
      for (int num : arr) {
         System.out.print(num + " ");
      }
   }
}

