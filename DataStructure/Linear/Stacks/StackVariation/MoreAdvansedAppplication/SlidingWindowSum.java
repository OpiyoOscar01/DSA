package DataStructure.Linear.Stacks.StackVariation.MoreAdvansedAppplication;

public class SlidingWindowSum {
   // Method to find the sum of subarrays of size k using sliding window
   public static void slidingWindowSum(int[] arr, int k) {
      int n = arr.length;

      // Step 1: Calculate the sum of the first window of size k
      int windowSum = 0;
      for (int i = 0; i < k; i++) {
         windowSum += arr[i];
      }

      System.out.println("Sum of subarray [" + 0 + "," + (k - 1) + "] is: " + windowSum);

      // Step 2: Slide the window over the rest of the array
      for (int i = k; i < n; i++) {
         // Subtract the element that's leaving the window (arr[i-k])
         // Add the element that's entering the window (arr[i])
         windowSum += arr[i] - arr[i - k];
         System.out.println("Sum of subarray [" + (i - k + 1) + "," + i + "] is: " + windowSum);
      }
   }

   public static void main(String[] args) {
      int[] arr = {1, 3, 5, 7, 9, 11};
      int k = 3;
      slidingWindowSum(arr, k);
   }
}

