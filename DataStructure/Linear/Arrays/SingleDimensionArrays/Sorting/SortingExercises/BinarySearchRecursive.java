package DataStructure.Linear.Arrays.SingleDimensionArrays.Sorting.SortingExercises;

public class BinarySearchRecursive {

   // Recursive binary search method
   public static int binarySearch(int[] arr, int target, int left, int right) {
      if (left <= right) {
         int mid = left + (right - left) / 2;

         // Check if the target is at the middle
         if (arr[mid] == target) {
            return mid;
         }

         // If target is smaller, search the left half
         if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
         }

         // If target is larger, search the right half
         return binarySearch(arr, target, mid + 1, right);
      }

      // Target is not found in the array
      return -1;
   }

   public static void main(String[] args) {
      // Sample sorted array
      int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};

      // Target value to search for
      int target = 10;

      // Perform binary search
      int result = binarySearch(arr, target, 0, arr.length - 1);

      // Display the result
      if (result != -1) {
         System.out.println("Element found at index: " + result);
      } else {
         System.out.println("Element not found.");
      }
   }
}

