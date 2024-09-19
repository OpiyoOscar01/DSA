package DataStructure.Linear.Arrays.SingleDimensionArrays;

public class BinarySearch {
   public static String binarySearch(int[] arr, int target) {
      if (arr == null || arr.length == 0) {
         System.out.println("The array is null or empty");
      } else {
         int[] marks = {2, 3, 4, 4, 5, 9};
         int low = 0, high = arr.length - 1;
         while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
               return target + " found at index " + mid;
            } else if (arr[mid] < target) {
               low = mid + 1;
            } else {
               high = mid - 1;
            }
         }

      }
      return "Search item not found";
   }

   public static void main(String[] args) {
      int[] scores = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      System.out.println(binarySearch(scores, 8));
   }
}
